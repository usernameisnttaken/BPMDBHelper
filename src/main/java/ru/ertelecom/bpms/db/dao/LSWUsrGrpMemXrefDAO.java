package ru.ertelecom.bpms.db.dao;

import ru.ertelecom.bpms.db.entity.LSWUsrGrpMemXref;
import ru.ertelecom.bpms.db.utils.BPMHibernateSessionFactoryUtil;

import java.util.List;

public class LSWUsrGrpMemXrefDAO {
    public List<LSWUsrGrpMemXref> findByUserId(final Long userId) {
        return BPMHibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .createQuery("FROM LSWUsrGrpMemXref WHERE userId = :userId")
                .setParameter("userId", userId)
                .list();
    }

    public List<LSWUsrGrpMemXref> findByGroupId(final Long groupId) {
        return BPMHibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .createQuery("FROM LSWUsrGrpMemXref WHERE groupId = :groupId")
                .setParameter("groupId", groupId)
                .list();
    }

    public LSWUsrGrpMemXref findByUserIdAndGroupId(final Long userId, final Long groupId) {
        return (LSWUsrGrpMemXref) BPMHibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .createQuery("FROM LSWUsrGrpMemXref WHERE userId = :userId AND groupId = :groupId")
                .setParameter("userId", userId)
                .setParameter("groupId", groupId)
                .uniqueResult();
    }
}
