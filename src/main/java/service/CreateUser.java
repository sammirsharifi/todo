package service;

import repository.CreateUserRepo;

import java.util.Scanner;

public class CreateUser extends CreateUserRepo {

    Scanner scanner=new Scanner(System.in);
    public void getInfo()
    {
        String username,password;
        System.out.println("USERNAME:\n");
        username=scanner.next();
        System.out.println("PASSWORD:\n");
        password=scanner.next();
        try {
            create(username,password);
        }
        catch (Exception e)
        {
            System.out.println("Error.please try again");
        }

    }



}
