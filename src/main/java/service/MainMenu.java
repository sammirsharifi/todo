package service;

import java.util.Scanner;

public class MainMenu {
    private Scanner scanner=new Scanner(System.in);

    public void showMenu()
    {
        System.out.println("1.LogIn\n2." +
                "CreateAccount");

        int input=scanner.nextInt();
        switch (input)
        {
            case 1:
                Login login=new Login();
                login.getInfo();
                break;
            case 2:
                CreateUser createUser=new CreateUser();
                createUser.getInfo();
                showMenu();
                break;
            default:
                System.out.println("Error.please try again.");
                showMenu();
        }
    }
}
