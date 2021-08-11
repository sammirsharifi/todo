package service.dto;

import org.hibernate.Hibernate;
import util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public abstract class BaseDto {

    EntityManagerFactory entityManagerFactory= HibernateUtil.getEntityMangerFactory();
    EntityManager entityManager=entityManagerFactory.createEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public EntityTransaction getTransaction() {
        return transaction;
    }
}
