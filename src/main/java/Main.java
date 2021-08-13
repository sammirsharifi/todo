import domain.Activity;
import repository.BaseEntry;
import repository.BaseEntryImpl;
import service.CreateUser;
import service.Login;
import service.MainMenu;
import service.UserMenu;
import util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        MainMenu main=new MainMenu();
        main.showMenu();






    }
}
