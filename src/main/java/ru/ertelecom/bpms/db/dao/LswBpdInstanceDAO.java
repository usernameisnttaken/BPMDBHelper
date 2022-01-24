package ru.ertelecom.bpms.db.dao;

import ru.ertelecom.bpms.db.entity.LSWBpdInstance;
import ru.ertelecom.bpms.db.utils.BPMHibernateSessionFactoryUtil;

import java.util.Date;
import java.util.List;

public class LswBpdInstanceDAO {
    public LSWBpdInstance findByBpdInstanceId(final Long bpdInstanceId) {
        return BPMHibernateSessionFactoryUtil.getSessionFactory().openSession().get(LSWBpdInstance.class, bpdInstanceId);
    }

    public List<LSWBpdInstance> findAll() {
        return (List<LSWBpdInstance>)
                BPMHibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .createQuery("FROM LSWBpdInstance")
                .list();
    }

    public List<LSWBpdInstance> findAllCreatedBetween(final Date createdAfter, final Date createdBefore) {
        return (List<LSWBpdInstance>)
                BPMHibernateSessionFactoryUtil
                        .getSessionFactory()
                        .openSession()
                        .createQuery("FROM LSWBpdInstance pi WHERE pi.createDatetime between :start and :end")
                        .setParameter("start", createdAfter)
                        .setParameter("end", createdBefore)
                        .list();
    }

    public List<LSWBpdInstance> findAllByProjectId(final String projectId) {
        return (List<LSWBpdInstance>)
                BPMHibernateSessionFactoryUtil
                        .getSessionFactory()
                        .openSession()
                        .createQuery("FROM LSWBpdInstance pi WHERE pi.projectId = :prId")
                        .setParameter("prId", projectId)
                        .list();
    }

    public List<LSWBpdInstance> findAllByProjectAcronym(final String acronym) {
        return (List<LSWBpdInstance>) BPMHibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .createQuery("FROM LSWBpdInstance bpi WHERE bpi.bpmProject.acronym = :acronym")
                .setParameter("acronym", acronym)
                .list();
    }
}
