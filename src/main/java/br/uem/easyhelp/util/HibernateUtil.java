package br.uem.easyhelp.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Douglas
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public HibernateUtil() {
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration annotation = new Configuration();
                sessionFactory = annotation.configure().buildSessionFactory();
            } catch (Throwable ex) {
                System.out.println("Erro ao inicar o Hibernate " + ex);
                throw new ExceptionInInitializerError(ex);
            }
        }
        return sessionFactory;
    }
}
