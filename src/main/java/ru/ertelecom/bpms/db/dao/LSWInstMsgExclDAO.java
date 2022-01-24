package ru.ertelecom.bpms.db.dao;

import ru.ertelecom.bpms.db.entity.LSWInstMsgExcl;
import ru.ertelecom.bpms.db.utils.BPMHibernateSessionFactoryUtil;

import java.util.List;

public class LSWInstMsgExclDAO {
    public List<LSWInstMsgExcl> findByBpdInstanceId(final Long bpdInstanceId) {
        return (List<LSWInstMsgExcl>)
                BPMHibernateSessionFactoryUtil
                        .getSessionFactory()
                        .openSession()
                        .createQuery("FROM LSWInstMsgExcl WHERE bpdInstanceId = :bpdInstanceId")
                        .setParameter("bpdInstanceId", bpdInstanceId)
                        .list();
    }
}
