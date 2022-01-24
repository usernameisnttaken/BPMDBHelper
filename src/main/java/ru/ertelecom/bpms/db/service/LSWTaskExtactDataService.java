package ru.ertelecom.bpms.db.service;

import ru.ertelecom.bpms.db.dao.LSWTaskExtactDataDAO;
import ru.ertelecom.bpms.db.entity.LSWTaskExtactData;

import java.util.List;


public class LSWTaskExtactDataService {
    private final LSWTaskExtactDataDAO bpmTasExtactDataDAO = new LSWTaskExtactDataDAO();

    public LSWTaskExtactDataService() {}

    public List<LSWTaskExtactData> findByTaskId(final Long taskId) {
        return bpmTasExtactDataDAO.findByTaskId(taskId);
    }
}
