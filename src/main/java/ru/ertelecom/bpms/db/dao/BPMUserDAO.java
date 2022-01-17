package ru.ertelecom.bpms.db.dao;

import ru.ertelecom.bpms.db.entity.BPMUser;
import ru.ertelecom.bpms.db.utils.BPMHibernateSessionFactoryUtil;

import java.util.List;

public class BPMUserDAO {
    public BPMUser findByUserId(final Long userId) {
        return BPMHibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .get(BPMUser.class, userId);
    }

    public List<BPMUser> findAll() {
        return (List<BPMUser>)
                BPMHibernateSessionFactoryUtil
                        .getSessionFactory()
                        .openSession()
                        .createQuery("FROM BPMUser")
                        .list();
    }
}
