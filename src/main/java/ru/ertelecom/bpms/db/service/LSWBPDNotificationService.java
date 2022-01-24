package ru.ertelecom.bpms.db.service;

import ru.ertelecom.bpms.db.dao.LSWBPDNotificationDAO;
import ru.ertelecom.bpms.db.entity.LSWBPDNotification;

import java.util.List;

public class LSWBPDNotificationService {
    private final LSWBPDNotificationDAO lswbpdNotificationDAO = new LSWBPDNotificationDAO();

    public LSWBPDNotificationService() {}

    public List<LSWBPDNotification> findByBpdInstanceId(final Long bpdInstanceId) {
        return lswbpdNotificationDAO.findByBpdInstanceId(bpdInstanceId);
    }
}
