package ru.ertelecom.bpms.db.dao;

import ru.ertelecom.bpms.db.entity.BPMTaskInstance;
import ru.ertelecom.bpms.db.utils.BPMHibernateSessionFactoryUtil;

import java.util.List;

public class BPMTaskInstanceDAO {
    public BPMTaskInstance findByTaskId(final Long taskId) {
        return BPMHibernateSessionFactoryUtil.getSessionFactory().openSession().get(BPMTaskInstance.class, taskId);
    }

    public List<BPMTaskInstance> findAllByBpdInstanceId(final Long bpdInstanceId, final Integer activityTaskTypeId) {
//        String hqlQuery = "FROM BPMTaskInstance bti WHERE bti.bpdInstanceId = :bpdInstanceId";
//        if (activityTaskType !== null)
//            hqlQuery += " and bti.activityTaskTypeId = :actTaskTypeId";
        List<BPMTaskInstance> bpmTaskInstances = (List<BPMTaskInstance>)
                BPMHibernateSessionFactoryUtil
                        .getSessionFactory()
                        .openSession()
                        .createQuery("FROM BPMTaskInstance bti WHERE bti.bpdInstanceId = :bpdInstanceId and (:activityTaskTypeId is null or bti.activityTaskTypeId = :activityTaskTypeId)")
                        .setParameter("bpdInstanceId", bpdInstanceId)
                        .setParameter("activityTaskTypeId", activityTaskTypeId)
                        .list();
        return bpmTaskInstances;
    }
}
