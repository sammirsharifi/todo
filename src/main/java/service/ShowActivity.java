package service;

import domain.Activity;
import util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class ShowActivity {
    private int userId;
    public ShowActivity(int userId) {
        this.userId=userId;
    }

    EntityManagerFactory entityManagerFactory= HibernateUtil.getEntityMangerFactory();
    EntityManager entityManager=entityManagerFactory.createEntityManager();



}
