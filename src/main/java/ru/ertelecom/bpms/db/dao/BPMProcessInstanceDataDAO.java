package ru.ertelecom.bpms.db.dao;

import ru.ertelecom.bpms.db.entity.BPMProcessInstanceData;
import ru.ertelecom.bpms.db.utils.BPMHibernateSessionFactoryUtil;

import java.util.List;

public class BPMProcessInstanceDataDAO {
    public BPMProcessInstanceData findByBpdInstanceId(Long bpdInstanceId) {
        return BPMHibernateSessionFactoryUtil.getSessionFactory().openSession().get(BPMProcessInstanceData.class, bpdInstanceId);
    }

    public List<BPMProcessInstanceData> findAll() {
        List<BPMProcessInstanceData> bpmProcessInstanceDataList = (List<BPMProcessInstanceData>) BPMHibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .createQuery("FROM BPMProcessInstanceData")
                .list();
        return bpmProcessInstanceDataList;
    }
}
