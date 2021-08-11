package service.dto;

import domain.Activity;

import java.time.LocalDate;

public class ActivityDto extends BaseDto{

    LocalDate date=LocalDate.now();


    public void addActivity(Integer type)
    {
        getTransaction().begin();
        Activity activity=new Activity();
        switch (type)
        {
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
        activity.setCreateDate(String.format("%s",date));
        activity.setUser(1);
        getEntityManager().persist(activity);
        getTransaction().commit();
    }

}
