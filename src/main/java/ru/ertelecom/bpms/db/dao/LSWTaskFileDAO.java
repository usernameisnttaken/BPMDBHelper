package ru.ertelecom.bpms.db.dao;

import ru.ertelecom.bpms.db.entity.LSWTaskFile;
import ru.ertelecom.bpms.db.utils.BPMHibernateSessionFactoryUtil;

import java.util.List;

public class LSWTaskFileDAO {
    public List<LSWTaskFile> findByTaskId(final Long taskId) {
        return (List<LSWTaskFile>)
                BPMHibernateSessionFactoryUtil
                        .getSessionFactory()
                        .openSession()
                        .createQuery("FROM LSWTaskFile WHERE taskId = :taskId")
                        .setParameter("taskId", taskId)
                        .list();
    }
}
