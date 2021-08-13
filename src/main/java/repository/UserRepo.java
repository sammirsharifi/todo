package repository;

import domain.Activity;
import domain.User;
import util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class UserRepo{

    EntityManagerFactory entityManagerFactory= HibernateUtil.getEntityMangerFactory();
    EntityManager entityManager=entityManagerFactory.createEntityManager();







}
