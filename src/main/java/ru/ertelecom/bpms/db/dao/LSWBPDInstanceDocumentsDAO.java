package ru.ertelecom.bpms.db.dao;

import ru.ertelecom.bpms.db.entity.LSWBPDInstanceDocuments;
import ru.ertelecom.bpms.db.utils.BPMHibernateSessionFactoryUtil;

import java.util.List;

public class LSWBPDInstanceDocumentsDAO {
    public List<LSWBPDInstanceDocuments> findByBPDInstanceId(final Long bpdInstanceId) {
        return (List<LSWBPDInstanceDocuments>)
                BPMHibernateSessionFactoryUtil
                        .getSessionFactory()
                        .openSession()
                        .createQuery("FROM LSWBPDInstanceDocuments WHERE bpdInstanceId = :bpdInstanceId")
                        .setParameter("bpdInstanceId", bpdInstanceId)
                        .list();
    }
}
