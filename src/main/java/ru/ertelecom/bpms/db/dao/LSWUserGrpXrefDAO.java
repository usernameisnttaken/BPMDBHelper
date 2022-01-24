package ru.ertelecom.bpms.db.dao;

import ru.ertelecom.bpms.db.entity.LSWUsrGrpXref;
import ru.ertelecom.bpms.db.utils.BPMHibernateSessionFactoryUtil;


public class LSWUserGrpXrefDAO {
    public LSWUsrGrpXref findByGroupId(final Long groupId) {
        return BPMHibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .get(LSWUsrGrpXref.class, groupId);
    }
}
