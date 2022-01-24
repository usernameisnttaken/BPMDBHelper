package ru.ertelecom.bpms.db.dao;

import ru.ertelecom.bpms.db.entity.LSWUsrXref;
import ru.ertelecom.bpms.db.utils.BPMHibernateSessionFactoryUtil;

import java.util.List;

public class LSWUsrXrefDAO {
    public LSWUsrXref findByUserId(final Long userId) {
        return BPMHibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .get(LSWUsrXref.class, userId);
    }

    public List<LSWUsrXref> findAll() {
        return (List<LSWUsrXref>)
                BPMHibernateSessionFactoryUtil
                        .getSessionFactory()
                        .openSession()
                        .createQuery("FROM LSWUsrXref")
                        .list();
    }
}
