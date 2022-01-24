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

            configuration.addAnnotatedClass(LSWBpdInstance.class);
            configuration.addAnnotatedClass(LSWBPDInstanceData.class);
            configuration.addAnnotatedClass(LSWTask.class);
            configuration.addAnnotatedClass(LSWTaskAddr.class);
            configuration.addAnnotatedClass(LSWTaskExecutionContext.class);
            configuration.addAnnotatedClass(LSWTaskNarr.class);
            configuration.addAnnotatedClass(LSWTaskFile.class);
            configuration.addAnnotatedClass(LSWTaskIpfData.class);
            configuration.addAnnotatedClass(LSWTaskExtactData.class);
            configuration.addAnnotatedClass(BPMECMObject.class);
            configuration.addAnnotatedClass(LSWBPDActivityInstance.class);
            configuration.addAnnotatedClass(LSWBpdInstanceSharedUsage.class);
            configuration.addAnnotatedClass(BPMECMObject.class);
            configuration.addAnnotatedClass(LSWInstMsgExcl.class);
            configuration.addAnnotatedClass(LSWInstMsgIncl.class);
            configuration.addAnnotatedClass(LSWRuntimeError.class);
            configuration.addAnnotatedClass(LSWBPDNotification.class);
            configuration.addAnnotatedClass(LSWBPDInstanceExtData.class);
            configuration.addAnnotatedClass(LSWBPDInstanceCorrelation.class);
            configuration.addAnnotatedClass(LSWBPDInstanceDocuments.class);
            configuration.addAnnotatedClass(LSWBPDInstanceDocProps.class);
            configuration.addAnnotatedClass(LSWBPDInstanceVariables.class);
            configuration.addAnnotatedClass(LSWGrpGrpMemExplodedXref.class);
            configuration.addAnnotatedClass(LSWGrpGrpMemXref.class);
            configuration.addAnnotatedClass(LSWUsrGrpMemXref.class);

            configuration.addAnnotatedClass(LSWUsrXref.class);
            configuration.addAnnotatedClass(LSWUsrGrpXref.class);

            configuration.addAnnotatedClass(BPMProject.class);

            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
            sessionFactory = configuration.buildSessionFactory(builder.build());
        }
        return sessionFactory;
    }
}
