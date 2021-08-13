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
    private User user;
    EntityManagerFactory entityManagerFactory = HibernateUtil.getEntityMangerFactory();


    public UserMenu(User user) {
        this.user=user;
    }

    public void menu()
    {
        printMenu();
        int input=scanner.nextInt();

        switch (input)
        {
            case 1:
                addActivity();
                menu();
                break;
            case 2:
                editActivity();
                menu();
                break;
            case 3:
                showActivity();
                menu();
                break;
            default:
                System.out.println("wrong input");
                menu();
        }


    }
    public void printMenu() {
        System.out.println("1.add Activity\n2.edit Activity\n3.show activities");
    }

    public void addActivity() {

        try {
            System.out.println("Please enter your activity name.");
            String name=scanner.next();
            if (activityDto.isExist(name))
                throw new ArrayIndexOutOfBoundsException();
            System.out.println("Please specify your activity type:\n1.Open\n2.In progress\n3.Completed");
            int input = scanner.nextInt();
            if (input >= 4 && input <= 0) {
                throw new Exception();
            }
            activityDto.addActivity(input, user.getId(),name);
            System.out.println("successfully Done!");

        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("this activityName is exist.");
            addActivity();
        } catch(Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error! please try again.");
            addActivity();
        }
    }

    public void editActivity() {
        System.out.println("please enter ActivityName.");
        try
        {
            activityDto.editActivity(user.getId(), scanner.next());
            System.out.println("successfully Done!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error.please try again.");
            editActivity();
        }
    }


    public void showActivity()
    {
        System.out.println("show by:\n1.name\n2.type\n3.createDate");
        int input=scanner.nextInt();
        activityDto.showActivity(input,1, user.getId());

    }
}
