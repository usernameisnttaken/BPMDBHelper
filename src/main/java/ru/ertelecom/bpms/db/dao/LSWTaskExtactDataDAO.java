package ru.ertelecom.bpms.db.dao;

import ru.ertelecom.bpms.db.entity.LSWTaskExtactData;
import ru.ertelecom.bpms.db.utils.BPMHibernateSessionFactoryUtil;

import java.util.List;

public class LSWTaskExtactDataDAO {
    public List<LSWTaskExtactData> findByTaskId(final Long taskId) {
        return (List<LSWTaskExtactData>)
                BPMHibernateSessionFactoryUtil
                        .getSessionFactory()
                        .openSession()
                        .createQuery("FROM LSWTaskExtactData WHERE taskId = :taskId")
                        .setParameter("taskId", taskId)
                        .list();
    }
}
