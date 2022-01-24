package ru.ertelecom.bpms.db.service;

import ru.ertelecom.bpms.db.dao.LSWTaskIpfDataDAO;
import ru.ertelecom.bpms.db.entity.LSWTaskIpfData;

import java.util.List;

public class LSWTaskIpfDataService {
    private final LSWTaskIpfDataDAO LSWTaskIpfDataDAO = new LSWTaskIpfDataDAO();

    public LSWTaskIpfDataService() {

    }

    public List<LSWTaskIpfData> findByTaskId(final Long taskId) {
        return LSWTaskIpfDataDAO.findByTaskId(taskId);
    }
}
