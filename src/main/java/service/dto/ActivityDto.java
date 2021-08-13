package service.dto;

import domain.Activity;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ActivityDto extends BaseDto {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    Scanner scanner = new Scanner(System.in);
    LocalDate date = LocalDate.now();


    public void addActivity(Integer type,int UserId,String name) {
        getTransaction().begin();
        Activity activity = new Activity();
        switch (type) {
            case 1:
                activity.setActivityType("Open");
                break;
            case 2:
                activity.setActivityType("In progress");
                break;
            case 3:
                activity.setActivityType("Completed");
                break;
        }
        activity.setCreateDate(String.format("%s", date));
        activity.setUser(UserId);
        activity.setActivityName(name);
        getEntityManager().persist(activity);
        getTransaction().commit();
    }

    public void editActivity(int userId, String name) {

        entityManager.getTransaction().begin();
        List<Activity> activityList = entityManager.createQuery(String.format("from Activity where userid=%s and %s='%s'", userId, Activity.ActivityName), Activity.class).getResultList();
        System.out.println(activityList);
        System.out.println("Please specify a new type of your activity\n1.Open\n2.In progress\n3.Completed");
        try {
            int input = scanner.nextInt();
            if (input >= 4 && input <= 0) {
                throw new Exception();
            }
            String newType = null;
            switch (input)
            {
                case 1:
                    newType="Open";
                    break;
                case 2:
                    newType="In progress";
                    break;
                case 3:
                    newType="Completed";
                    break;
            }
            activityList.get(0).setActivityType(newType);
        } catch (Exception e) {
            System.out.println("Error.please try again");
        }
        entityManager.getTransaction().commit();
        entityManager.close();


    }


    public boolean isExist(String name) {
        boolean result=true;

        entityManager.getTransaction().begin();

        if (entityManager.createQuery(String.format("from Activity where %s ='%s'", Activity.ActivityName,name)).getResultList().isEmpty())
            result=false;
        entityManager.getTransaction().commit();

        return result;
    }

    public void showActivity(int byWhat,int a,int userId)
    {


        entityManager.getTransaction().begin();
        List<Activity> activities=entityManager.createQuery(String.format("from Activity where %s=%s",Activity.UserId,userId)).getResultList();
        entityManager.getTransaction().commit();
        switch(byWhat)
        {
            case 1:
                Collections.sort(activities,Activity::compareToByName);

                break;
            case 2:
                Collections.sort(activities,Activity::compareToByType);

                break;
            case 3:
                Collections.sort(activities,Activity::compareToById);

                break;

            default:
                System.out.println("Error.please try again.");
        }

        Iterator<Activity> it=activities.iterator();
        while (it.hasNext())
            System.out.println(it.next());
    }

}
