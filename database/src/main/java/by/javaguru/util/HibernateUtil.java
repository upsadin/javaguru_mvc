package by.javaguru.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
    public static SessionFactory buildSessionFactory() {
        Configuration configuration = new Configuration().configure();
        return configuration.buildSessionFactory();
    }
}
