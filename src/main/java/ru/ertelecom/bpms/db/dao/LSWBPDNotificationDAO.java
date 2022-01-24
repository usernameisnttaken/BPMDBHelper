package ru.ertelecom.bpms.db.dao;

import ru.ertelecom.bpms.db.entity.LSWBPDNotification;
import ru.ertelecom.bpms.db.utils.BPMHibernateSessionFactoryUtil;

import java.util.List;

public class LSWBPDNotificationDAO {
    public List<LSWBPDNotification> findByBpdInstanceId(final Long bpdInstanceId) {
        return (List<LSWBPDNotification>)
                BPMHibernateSessionFactoryUtil
                        .getSessionFactory()
                        .openSession()
                        .createQuery("FROM LSWBPDNotification WHERE bpdInstanceId = :bpdInstanceId")
                        .setParameter("bpdInstanceId", bpdInstanceId)
                        .list();
    }
}
