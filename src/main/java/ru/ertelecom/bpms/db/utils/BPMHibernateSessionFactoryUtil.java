package ru.ertelecom.bpms.db.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import ru.ertelecom.bpms.db.entity.*;


public class BPMHibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;

    private BPMHibernateSessionFactoryUtil() {
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration().configure();

            configuration.addAnnotatedClass(BPMProcessInstance.class);
            configuration.addAnnotatedClass(BPMProcessInstanceData.class);
            configuration.addAnnotatedClass(BPMTaskInstance.class);
            configuration.addAnnotatedClass(BPMProject.class);
            configuration.addAnnotatedClass(BPMUser.class);
            configuration.addAnnotatedClass(BPMGroup.class);

            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
            sessionFactory = configuration.buildSessionFactory(builder.build());
        }
        return sessionFactory;
    }
}
