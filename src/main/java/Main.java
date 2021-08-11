import service.UserMenu;
import util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {




        UserMenu userMenu=new UserMenu();
        userMenu.editActivity();


    }
}
