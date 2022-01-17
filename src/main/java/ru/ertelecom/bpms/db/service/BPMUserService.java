package ru.ertelecom.bpms.db.service;

import ru.ertelecom.bpms.db.dao.BPMUserDAO;
import ru.ertelecom.bpms.db.entity.BPMUser;

import java.util.List;

public class BPMUserService {
    private final BPMUserDAO bpmUserDAO = new BPMUserDAO();

    public BPMUserService() {
    }

    public BPMUser findByUserId(final Long userId) {
        return bpmUserDAO.findByUserId(userId);
    }

    public List<BPMUser> findAll() {
        return bpmUserDAO.findAll();
    }
}
