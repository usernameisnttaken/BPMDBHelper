package ru.ertelecom.bpms.db.dao;

import ru.ertelecom.bpms.db.entity.LSWTaskIpfData;
import ru.ertelecom.bpms.db.utils.BPMHibernateSessionFactoryUtil;

import java.util.List;

public class LSWTaskIpfDataDAO {
    public List<LSWTaskIpfData> findByTaskId(final Long taskId) {
        return (List<LSWTaskIpfData>)
                BPMHibernateSessionFactoryUtil
                        .getSessionFactory()
                        .openSession()
                        .createQuery("FROM LSWTaskIpfData WHERE taskId = :taskId")
                        .setParameter("taskId", taskId)
                        .list();
    }
}
