package ru.ertelecom.bpms.db.dao;

import ru.ertelecom.bpms.db.entity.LSWInstMsgIncl;
import ru.ertelecom.bpms.db.utils.BPMHibernateSessionFactoryUtil;

import java.util.List;

public class LSWInstMsgInclDAO {
    public List<LSWInstMsgIncl> findByBpdInstanceId(final Long bpdInstanceId) {
        return (List<LSWInstMsgIncl>)
                BPMHibernateSessionFactoryUtil
                        .getSessionFactory()
                        .openSession()
                        .createQuery("FROM LSWInstMsgIncl WHERE bpdInstanceId = :bpdInstanceId")
                        .setParameter("bpdInstanceId", bpdInstanceId)
                        .list();
    }
}
