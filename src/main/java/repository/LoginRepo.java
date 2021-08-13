package repository;

import domain.User;
import service.MainMenu;
import service.UserMenu;
import util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class LoginRepo extends BaseEntryImpl {


    EntityManagerFactory entityManagerFactory= HibernateUtil.getEntityMangerFactory();
    EntityManager entityManager=entityManagerFactory.createEntityManager();

    public void logIn(String username,String password)
    {
        entityManager.getTransaction().begin();
        User user= (User) entityManager.createQuery(String.format("from User where username = '%s'",username)).getResultList().get(0);
        entityManager.getTransaction().commit();
        if (!isExist(username))
            {
                System.out.println("USERNAME not found ");
                MainMenu menu=new MainMenu();
                menu.showMenu();
            }
        else {

            if (isMatch(username,password)) {
                UserMenu userMenu = new UserMenu(user);
                userMenu.menu();

            }
            else

                System.out.println("your password is  wrong!");
            MainMenu menu=new MainMenu();
            menu.showMenu();
        }



    }


    public boolean isMatch(String username,String password)
    {
        boolean result=false;
        List<User> users=entityManager.createQuery(String.format("from User where %s ='%s'",User.user_name,username)).getResultList();

        if (users.get(0).getPassword().equals(password))
        {

            result=true;
        }
        return result;

    }
}
