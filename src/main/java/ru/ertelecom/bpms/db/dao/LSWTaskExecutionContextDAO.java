package ru.ertelecom.bpms.db.dao;

import ru.ertelecom.bpms.db.entity.LSWTaskExecutionContext;
import ru.ertelecom.bpms.db.utils.BPMHibernateSessionFactoryUtil;

import java.util.List;

public class LSWTaskExecutionContextDAO {
    public LSWTaskExecutionContext findByTaskExecutionContextId(final Long taskExecutionContextId) {
        return BPMHibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .get(LSWTaskExecutionContext.class, taskExecutionContextId);
    }

    public List<LSWTaskExecutionContext> findByTaskId(final Long taskId) {
        return (List<LSWTaskExecutionContext>)
                BPMHibernateSessionFactoryUtil
                        .getSessionFactory()
                        .openSession()
                        .createQuery("FROM LSWTaskExecutionContext WHERE taskId = :taskId")
                        .setParameter("taskId", taskId)
                        .list();
    }

}
