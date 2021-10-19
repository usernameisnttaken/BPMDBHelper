package ru.ertelecom.bpms.db.service;

import ru.ertelecom.bpms.db.dao.BPMTaskInstanceDAO;
import ru.ertelecom.bpms.db.entity.BPMTaskInstance;

import java.util.List;

public class BPMTaskInstanceService {
    private BPMTaskInstanceDAO bpmTaskInstanceDAO = new BPMTaskInstanceDAO();

    public BPMTaskInstanceService() {
    }

    public BPMTaskInstance findByTaskId(final Long taskId) {
        return bpmTaskInstanceDAO.findByTaskId(taskId);
    }

    public List<BPMTaskInstance> findAllByBpdInstanceId(final Long bpdInstanceId, final Integer activityTaskType) {
        return bpmTaskInstanceDAO.findAllByBpdInstanceId(bpdInstanceId, activityTaskType);
    }
}
