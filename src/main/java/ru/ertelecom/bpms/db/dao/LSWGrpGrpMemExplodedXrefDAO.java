package ru.ertelecom.bpms.db.dao;

import ru.ertelecom.bpms.db.entity.LSWGrpGrpMemExplodedXref;
import ru.ertelecom.bpms.db.utils.BPMHibernateSessionFactoryUtil;

import java.util.List;

public class LSWGrpGrpMemExplodedXrefDAO {
    public List<LSWGrpGrpMemExplodedXref> findByGroupId(final Long groupId) {
        return (List<LSWGrpGrpMemExplodedXref>)
                BPMHibernateSessionFactoryUtil
                        .getSessionFactory()
                        .openSession()
                        .createQuery("FROM LSWGrpGrpMemExplodedXref WHERE groupId = :groupId")
                        .setParameter("groupId", groupId)
                        .list();
    }
}
