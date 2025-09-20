package fit.iuh.se.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class AppDriver {
    public static final String PERSISTENCE = "cart-management";
    public static EntityManagerFactory emf = null;

    static {
        try {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static void close() {
        if(emf.isOpen()) emf.close();
    }
}
