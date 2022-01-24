package ru.ertelecom.bpms.db.dao;

import ru.ertelecom.bpms.db.entity.LSWTaskAddr;
import ru.ertelecom.bpms.db.utils.BPMHibernateSessionFactoryUtil;

import java.util.List;

public class LSWTaskAddrDAO {
    public LSWTaskAddr findByTaskAddrId(final Long taskAddrId) {
        return BPMHibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .get(LSWTaskAddr.class, taskAddrId);
    }

    public List<LSWTaskAddr> findByTaskId(final Long taskId) {
        return (List<LSWTaskAddr>)
                BPMHibernateSessionFactoryUtil
                        .getSessionFactory()
                        .openSession()
                        .createQuery("FROM LSWTaskAddr bta WHERE bta.taskId = :taskId")
                        .setParameter("taskId", taskId)
                        .list();
    }

}
