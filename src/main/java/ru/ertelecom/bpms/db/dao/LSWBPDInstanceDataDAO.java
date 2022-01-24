package ru.ertelecom.bpms.db.dao;

import ru.ertelecom.bpms.db.entity.LSWBPDInstanceData;
import ru.ertelecom.bpms.db.utils.BPMHibernateSessionFactoryUtil;

import java.util.List;

public class LSWBPDInstanceDataDAO {
    public LSWBPDInstanceData findByBpdInstanceId(Long bpdInstanceId) {
        return BPMHibernateSessionFactoryUtil.getSessionFactory().openSession().get(LSWBPDInstanceData.class, bpdInstanceId);
    }
}
