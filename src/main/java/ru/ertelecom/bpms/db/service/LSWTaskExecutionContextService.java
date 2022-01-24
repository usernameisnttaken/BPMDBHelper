package ru.ertelecom.bpms.db.service;

import ru.ertelecom.bpms.db.dao.LSWTaskExecutionContextDAO;
import ru.ertelecom.bpms.db.entity.LSWTaskExecutionContext;

import java.util.List;

public class LSWTaskExecutionContextService {
    private final LSWTaskExecutionContextDAO LSWTaskExecutionContextDAO = new LSWTaskExecutionContextDAO();

    public LSWTaskExecutionContextService() {
    }

    public LSWTaskExecutionContext findByTaskExecutionContextId(final Long taskExecutionContextId) {
        return LSWTaskExecutionContextDAO.findByTaskExecutionContextId(taskExecutionContextId);
    }

    public List<LSWTaskExecutionContext> findByTaskId(final Long taskId) { return LSWTaskExecutionContextDAO.findByTaskId(taskId); }
}
