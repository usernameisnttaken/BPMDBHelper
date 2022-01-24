package ru.ertelecom.bpms.db.dao;

import ru.ertelecom.bpms.db.entity.LSWRuntimeError;
import ru.ertelecom.bpms.db.utils.BPMHibernateSessionFactoryUtil;

import java.util.List;

public class LSWRuntimeErrorDAO {
    public List<LSWRuntimeError> findByBPDInstanceId(final Long bpdInstanceId) {
        return (List<LSWRuntimeError>)
                BPMHibernateSessionFactoryUtil
                        .getSessionFactory()
                        .openSession()
                        .createQuery("FROM LSWRuntimeError WHERE bpdInstanceId = :bpdInstanceId")
                        .setParameter("bpdInstanceId", bpdInstanceId)
                        .list();
    }
}
