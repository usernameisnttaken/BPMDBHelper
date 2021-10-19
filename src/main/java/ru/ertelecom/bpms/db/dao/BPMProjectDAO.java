package ru.ertelecom.bpms.db.dao;

import ru.ertelecom.bpms.db.entity.BPMProject;
import ru.ertelecom.bpms.db.utils.BPMHibernateSessionFactoryUtil;

public class BPMProjectDAO {
    public BPMProject findByAcronym(final String acronym) {
        return (BPMProject) BPMHibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .createQuery("FROM BPMProject p WHERE p.acronym = :acr")
                .setParameter("acr", acronym).uniqueResult();
    }
}
