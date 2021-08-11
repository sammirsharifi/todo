package service;

import domain.Activity;
import domain.User;
import service.dto.ActivityDto;
import util.HibernateUtil;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.Scanner;


public class UserMenu {


    private Scanner scanner = new Scanner(System.in);
    private ActivityDto activityDto = new ActivityDto();

    EntityManagerFactory entityManagerFactory = HibernateUtil.getEntityMangerFactory();


    public void printMenu() {
        System.out.println("1.add Activity\n2.show Activity");
    }

    public void addActivity() {
        System.out.println("Please specify your activity type:\n1.Open\n2.In progress\n3.Completed");
        try {
            int input = scanner.nextInt();
            if (input >= 4 && input <= 0) {
                throw new Exception();
            }
            activityDto.addActivity(input);
            System.out.println("successfully Done!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error! please try again.");
            addActivity();
        }
    }

    public void editActivity() {
        System.out.println("please enter ActivityId.");
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Activity> activityList = entityManager.createQuery("from Activity where userid=1", Activity.class).getResultList();
        System.out.println(activityList);
        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
