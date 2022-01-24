package ru.ertelecom.bpms.db.dao;

import ru.ertelecom.bpms.db.entity.LSWTask;
import ru.ertelecom.bpms.db.utils.BPMHibernateSessionFactoryUtil;

import java.util.List;

public class LSWTaskDAO {
    public LSWTask findByTaskId(final Long taskId) {
        return BPMHibernateSessionFactoryUtil.getSessionFactory().openSession().get(LSWTask.class, taskId);
    }

    public List<LSWTask> findByBPDInstanceId(final Long bpdInstanceId) {
        return (List<LSWTask>)
                BPMHibernateSessionFactoryUtil
                        .getSessionFactory()
                        .openSession()
                        .createQuery("FROM LSWTask WHERE bpdInstanceId = :bpdInstanceId")
                        .setParameter("bpdInstanceId", bpdInstanceId)
                        .list();
    }

    public List<LSWTask> findAllByBpdInstanceIdAndActivityTaskTypeId(final Long bpdInstanceId, final Integer activityTaskTypeId) {
        return (List<LSWTask>)
                BPMHibernateSessionFactoryUtil
                        .getSessionFactory()
                        .openSession()
                        .createQuery("FROM LSWTask WHERE bpdInstanceId = :bpdInstanceId and (:activityTaskTypeId is null or bti.activityTaskTypeId = :activityTaskTypeId)")
                        .setParameter("bpdInstanceId", bpdInstanceId)
                        .setParameter("activityTaskTypeId", activityTaskTypeId)
                        .list();
    }
}
