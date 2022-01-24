package ru.ertelecom.bpms.db.service;

import ru.ertelecom.bpms.db.dao.LSWTaskDAO;
import ru.ertelecom.bpms.db.entity.LSWTask;

import java.util.List;

public class LSWTaskService {
    private final LSWTaskDAO LSWTaskDAO = new LSWTaskDAO();

    public LSWTaskService() {
    }

    public LSWTask findByTaskId(final Long taskId) {
        return LSWTaskDAO.findByTaskId(taskId);
    }

    public List<LSWTask> findByBpdInstanceId(final Long bpdInstanceId) {
        return LSWTaskDAO.findByBPDInstanceId(bpdInstanceId);
    }

    public List<LSWTask> findAllByBpdInstanceIdAndActivityTaskType(final Long bpdInstanceId, final Integer activityTaskType) {
        return LSWTaskDAO.findAllByBpdInstanceIdAndActivityTaskTypeId(bpdInstanceId, activityTaskType);
    }
}
