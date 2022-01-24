package ru.ertelecom.bpms.db.dao;

import ru.ertelecom.bpms.db.entity.BPMECMObject;
import ru.ertelecom.bpms.db.utils.BPMHibernateSessionFactoryUtil;

import java.util.List;

public class BPMECMObjectDAO {
    public List<BPMECMObject> findByBPDInstanceId(final Long bpdInstanceId) {
        return (List<BPMECMObject>)
                BPMHibernateSessionFactoryUtil
                        .getSessionFactory()
                        .openSession()
                        .createQuery("FROM BPMECMObject WHERE bpdInstanceId = :bpdInstanceId")
                        .setParameter("bpdInstanceId", bpdInstanceId)
                        .list();
    }
}
