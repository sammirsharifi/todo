package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

    private static final EntityManagerFactory entityMangerFactory;

    static {
        entityMangerFactory =
                Persistence.createEntityManagerFactory("sam");
    }

    public static EntityManagerFactory getEntityMangerFactory() {
        return entityMangerFactory;
    }
}
