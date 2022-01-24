package ru.ertelecom.bpms.db.dao;

import ru.ertelecom.bpms.db.entity.LSWBpdInstanceSharedUsage;
import ru.ertelecom.bpms.db.utils.BPMHibernateSessionFactoryUtil;

import java.util.List;

public class LSWBPDInstanceSharedUsageDAO {
    public List<LSWBpdInstanceSharedUsage> findByBpdInstanceId(final Long bpdInstanceId) {
        return (List<LSWBpdInstanceSharedUsage>)
                BPMHibernateSessionFactoryUtil
                        .getSessionFactory()
                        .openSession()
                        .createQuery("FROM LSWBpdInstanceSharedUsage WHERE bpdInstanceId = :bpdInstanceId")
                        .setParameter("bpdInstanceId", bpdInstanceId)
                        .list();
    }
}
