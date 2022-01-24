package ru.ertelecom.bpms.db.dao;

import ru.ertelecom.bpms.db.entity.LSWGrpGrpMemXref;
import ru.ertelecom.bpms.db.utils.BPMHibernateSessionFactoryUtil;

import java.util.List;

public class LSWGrpGrpMemXrefDAO {
    public List<LSWGrpGrpMemXref> findByGroupId(final Long groupId) {
        return (List<LSWGrpGrpMemXref>)
                BPMHibernateSessionFactoryUtil
                        .getSessionFactory()
                        .openSession()
                        .createQuery("FROM LSWGrpGrpMemXref WHERE groupId = :groupId")
                        .setParameter("groupId", groupId)
                        .list();
    }
}
