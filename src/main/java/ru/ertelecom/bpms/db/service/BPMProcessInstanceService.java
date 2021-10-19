package ru.ertelecom.bpms.db.service;

import ru.ertelecom.bpms.db.dao.BPMProcessInstanceDAO;
import ru.ertelecom.bpms.db.entity.BPMProcessInstance;

import java.util.Date;
import java.util.List;

public class BPMProcessInstanceService {
    private BPMProcessInstanceDAO bpmProcessInstanceDAO = new BPMProcessInstanceDAO();

    public BPMProcessInstanceService() {}

    public BPMProcessInstance findByBpdInstanceId(Long bpdInstanceId) {
        return bpmProcessInstanceDAO.findByBpdInstanceId(bpdInstanceId);
    }

    public List<BPMProcessInstance> findAll() {
        return bpmProcessInstanceDAO.findAll();
    }

    public List<BPMProcessInstance> findAllCreatedBetween(Date createdAfter, Date createdBefore) {
        return bpmProcessInstanceDAO.findAllCreatedBetween(createdAfter, createdBefore);
    }

    public List<BPMProcessInstance> findAllByProjectId(final String projectId) {
        return bpmProcessInstanceDAO.findAllByProjectId(projectId);
    }

    public List<BPMProcessInstance> findAllByProjectAcronym(final String acronym) {
        return bpmProcessInstanceDAO.findAllByProjectAcronym(acronym);
    }
}
