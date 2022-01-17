package ru.ertelecom.bpms.db.dao;

import ru.ertelecom.bpms.db.entity.BPMGroup;
import ru.ertelecom.bpms.db.utils.BPMHibernateSessionFactoryUtil;

import java.util.List;

public class BPMGroupDAO {
    public BPMGroup findByGroupId(final Long groupId) {
        return BPMHibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .get(BPMGroup.class, groupId);
    }

    public List<BPMGroup> findAll() {
        return (List<BPMGroup>)
                BPMHibernateSessionFactoryUtil
                        .getSessionFactory()
                        .openSession()
                        .createQuery("FROM BPMGroup")
                        .list();
    }
}
