package ru.ertelecom.bpms.db.dao;

import ru.ertelecom.bpms.db.entity.LSWBPDInstanceDocProps;
import ru.ertelecom.bpms.db.utils.BPMHibernateSessionFactoryUtil;

import java.util.List;

public class LSWBPDInstanceDocPropsDAO {
    public List<LSWBPDInstanceDocProps> findByDocId(final Long docId) {
        return (List<LSWBPDInstanceDocProps>)
                BPMHibernateSessionFactoryUtil
                        .getSessionFactory()
                        .openSession()
                        .createQuery("FROM LSWBPDInstanceDocProps WHERE docId = :docId")
                        .setParameter("docId", docId)
                        .list();
    }
}
