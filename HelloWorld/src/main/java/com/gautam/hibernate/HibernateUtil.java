package com.gautam.hibernate;

import java.util.logging.Logger;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class HibernateUtil {	
	
	private static final ThreadLocal threadLocal = new ThreadLocal();
    private static org.hibernate.SessionFactory sessionFactory;

    private static Configuration configuration = new Configuration();
    private static ServiceRegistry serviceRegistry; 

    private static final Logger log = Logger.getLogger(HibernateUtil.class.getName());

    static {
        try {
            configuration.configure();
            serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
            . buildServiceRegistry();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Exception e) {
            log.severe("Error Creating SessionFactory" + e);

        }
    }

    private HibernateUtil() {
    }

    public static Session getSession() throws HibernateException {
        Session session = (Session) threadLocal.get(); 
        if (session == null || !session.isOpen()) {
            if (sessionFactory == null) {
            	buildSessionFactory();
            }
            session = (sessionFactory != null) ? sessionFactory.openSession()
            : null;

            threadLocal.set(session);
        }
        return session;
    }

    public static void buildSessionFactory() {

        try {
            configuration.configure("hibernate/hibernate.cfg.xml");
            serviceRegistry = new ServiceRegistryBuilder(). applySettings(configuration.getProperties()) 
            .buildServiceRegistry();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Exception e) {
            log.severe("Error Creating SessionFactory" + e);
        }
    }

    public static void shutdown() throws HibernateException {
        Session session = (Session) threadLocal.get();
        threadLocal.set(null);
        if (session != null) {
            session.flush();
            session.close();

        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Configuration getConfiguration() {
        return configuration;
    }

}
