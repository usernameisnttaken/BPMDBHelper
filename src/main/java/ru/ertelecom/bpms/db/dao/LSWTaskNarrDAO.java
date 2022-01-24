package ru.ertelecom.bpms.db.dao;

import ru.ertelecom.bpms.db.entity.LSWTaskNarr;
import ru.ertelecom.bpms.db.utils.BPMHibernateSessionFactoryUtil;

import java.util.List;

public class LSWTaskNarrDAO {
    public LSWTaskNarr findByTaskNarrId(final Long taskNarrId) {
        return BPMHibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .get(LSWTaskNarr.class, taskNarrId);
    }

    public List<LSWTaskNarr> findByTaskId(final Long taskId) {
        return (List<LSWTaskNarr>)
                BPMHibernateSessionFactoryUtil
                        .getSessionFactory()
                        .openSession()
                        .createQuery("FROM LSWTaskNarr WHERE taskId = :taskId")
                        .setParameter("taskId", taskId)
                        .list();
    }

}
