package repository;

import domain.User;
import util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class BaseEntryImpl implements BaseEntry {
    EntityManagerFactory entityManagerFactory= HibernateUtil.getEntityMangerFactory();
    EntityManager entityManager=entityManagerFactory.createEntityManager();
    @Override
    public boolean isExist(String username) {
        boolean result=true;

        entityManager.getTransaction().begin();

        if (entityManager.createQuery(String.format("from User where %s ='%s'",User.user_name,username)).getResultList().isEmpty())
        result=false;
        entityManager.getTransaction().commit();

        return result;
    }
}
