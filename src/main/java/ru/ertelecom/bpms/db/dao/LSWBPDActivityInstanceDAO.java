package ru.ertelecom.bpms.db.dao;

import ru.ertelecom.bpms.db.entity.LSWBPDActivityInstance;
import ru.ertelecom.bpms.db.utils.BPMHibernateSessionFactoryUtil;

import java.util.List;

public class LSWBPDActivityInstanceDAO {
    public List<LSWBPDActivityInstance> findByBPDInstanceId(final Long bpdInstanceId) {
        return (List<LSWBPDActivityInstance>)
                BPMHibernateSessionFactoryUtil
                        .getSessionFactory()
                        .openSession()
                        .createQuery("FROM LSWBPDActivityInstance WHERE bpdInstanceId = :bpdInstanceId")
                        .setParameter("bpdInstanceId", bpdInstanceId)
                        .list();
    }
}
