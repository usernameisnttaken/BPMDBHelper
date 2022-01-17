package ru.ertelecom.bpms.db.dao;

import ru.ertelecom.bpms.db.entity.BPMProcessInstance;
import ru.ertelecom.bpms.db.utils.BPMHibernateSessionFactoryUtil;

import java.util.Date;
import java.util.List;

public class BPMProcessInstanceDAO {
    public BPMProcessInstance findByBpdInstanceId(final Long bpdInstanceId) {
        return BPMHibernateSessionFactoryUtil.getSessionFactory().openSession().get(BPMProcessInstance.class, bpdInstanceId);
    }

    public List<BPMProcessInstance> findAll() {
        return (List<BPMProcessInstance>)
                BPMHibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .createQuery("FROM BPMProcessInstance")
                .list();
    }

    public List<BPMProcessInstance> findAllCreatedBetween(final Date createdAfter, final Date createdBefore) {
        return (List<BPMProcessInstance>)
                BPMHibernateSessionFactoryUtil
                        .getSessionFactory()
                        .openSession()
                        .createQuery("FROM BPMProcessInstance pi WHERE pi.createDatetime between :start and :end")
                        .setParameter("start", createdAfter)
                        .setParameter("end", createdBefore)
                        .list();
    }

    public List<BPMProcessInstance> findAllByProjectId(final String projectId) {
        return (List<BPMProcessInstance>)
                BPMHibernateSessionFactoryUtil
                        .getSessionFactory()
                        .openSession()
                        .createQuery("FROM BPMProcessInstance pi WHERE pi.projectId = :prId")
                        .setParameter("prId", projectId)
                        .list();
    }

    public List<BPMProcessInstance> findAllByProjectAcronym(final String acronym) {
        return (List<BPMProcessInstance>) BPMHibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .createQuery("FROM BPMProcessInstance bpi WHERE bpi.bpmProject.acronym = :acronym")
                .setParameter("acronym", acronym)
                .list();
    }
}
