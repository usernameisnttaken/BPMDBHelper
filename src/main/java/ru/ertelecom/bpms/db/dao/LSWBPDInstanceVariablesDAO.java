package ru.ertelecom.bpms.db.dao;

import ru.ertelecom.bpms.db.entity.LSWBPDInstanceVariables;
import ru.ertelecom.bpms.db.utils.BPMHibernateSessionFactoryUtil;

import java.util.List;

public class LSWBPDInstanceVariablesDAO {
    public List<LSWBPDInstanceVariables> findByBpdInstanceId(final Long bpdInstanceId) {
        return (List<LSWBPDInstanceVariables>)
                BPMHibernateSessionFactoryUtil
                        .getSessionFactory()
                        .openSession()
                        .createQuery("FROM LSWBPDInstanceVariables WHERE bpdInstanceId = :bpdInstanceId")
                        .setParameter("bpdInstanceId", bpdInstanceId)
                        .list();
    }
}
