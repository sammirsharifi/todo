package service;

import repository.LoginRepo;

import java.util.Scanner;

public class Login extends LoginRepo {

    Scanner scanner=new Scanner(System.in);
    public void getInfo()
    {
        String username,password;
        System.out.println("USERNAME:\n");
        username=scanner.next();
        System.out.println("PASSWORD:\n");
        password=scanner.next();
        try {
            logIn(username,password);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Error.please try again");
            MainMenu menu=new MainMenu();
            menu.showMenu();
        }
    }
}
