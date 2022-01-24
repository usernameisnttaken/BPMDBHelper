package ru.ertelecom.bpms.db.service;

import ru.ertelecom.bpms.db.dao.LswBpdInstanceDAO;
import ru.ertelecom.bpms.db.entity.LSWBpdInstance;

import java.util.Date;
import java.util.List;

public class LSWBpdInstanceService {
    private final LswBpdInstanceDAO LSWBPDInstanceDAO = new LswBpdInstanceDAO();

    public LSWBpdInstanceService() {}

    public LSWBpdInstance findByBpdInstanceId(Long bpdInstanceId) {
        return LSWBPDInstanceDAO.findByBpdInstanceId(bpdInstanceId);
    }

    public List<LSWBpdInstance> findAll() {
        return LSWBPDInstanceDAO.findAll();
    }

    public List<LSWBpdInstance> findAllCreatedBetween(Date createdAfter, Date createdBefore) {
        return LSWBPDInstanceDAO.findAllCreatedBetween(createdAfter, createdBefore);
    }

    public List<LSWBpdInstance> findAllByProjectId(final String projectId) {
        return LSWBPDInstanceDAO.findAllByProjectId(projectId);
    }

    public List<LSWBpdInstance> findAllByProjectAcronym(final String acronym) {
        return LSWBPDInstanceDAO.findAllByProjectAcronym(acronym);
    }
}
