package fit.iuh.se.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class AppUtil {
    private static final String PERSISTENCE_UNIT_NAME = "default";
    private static final EntityManagerFactory emf;

    static {
        try {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError(e);
        }
    }

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static void close() {
        if(emf.isOpen()) {
            emf.close();
        }
    }

    public static void main(String[] args) {
        EntityManager em = AppUtil.getEntityManager();
    }
}
