package repository;

import domain.User;
import util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class CreateUserRepo extends BaseEntryImpl {

    EntityManagerFactory entityManagerFactory= HibernateUtil.getEntityMangerFactory();
    EntityManager entityManager=entityManagerFactory.createEntityManager();

    public void create(String username,String password)
    {
       entityManager.getTransaction().begin();
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        if (!isExist(username)) {
            entityManager.persist(user);
            System.out.println("Successfully Done!");
        }
        else
            System.out.println("USERNAME is already exist.");

        entityManager.getTransaction().commit();

    }


}
