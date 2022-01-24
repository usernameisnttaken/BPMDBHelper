package ru.ertelecom.bpms.db.service;

import ru.ertelecom.bpms.db.dao.LSWTaskAddrDAO;
import ru.ertelecom.bpms.db.entity.LSWTaskAddr;

import java.util.List;

public class LSWTaskAddrService {
    private final LSWTaskAddrDAO LSWTaskAddrDAO = new LSWTaskAddrDAO();

    public LSWTaskAddrService() {
    }

    public LSWTaskAddr findByTaskAddrId(final Long taskAddrId) {
        return LSWTaskAddrDAO.findByTaskAddrId(taskAddrId);
    }

    public List<LSWTaskAddr> findByTaskId(final Long taskId) { return LSWTaskAddrDAO.findByTaskId(taskId); }

}
