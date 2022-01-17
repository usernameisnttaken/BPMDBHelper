package ru.ertelecom.bpms.db.service;

import ru.ertelecom.bpms.db.dao.BPMGroupDAO;
import ru.ertelecom.bpms.db.entity.BPMGroup;

import java.util.List;

public class BPMGroupService {
    private final BPMGroupDAO bpmGroupDAO = new BPMGroupDAO();

    public BPMGroupService() {
    }

    public BPMGroup findByGroupId(final Long groupId) {
        return bpmGroupDAO.findByGroupId(groupId);
    }

    public List<BPMGroup> findAll() {
        return bpmGroupDAO.findAll();
    }
}
