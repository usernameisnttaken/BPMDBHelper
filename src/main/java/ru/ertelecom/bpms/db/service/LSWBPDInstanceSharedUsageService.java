package ru.ertelecom.bpms.db.service;

import ru.ertelecom.bpms.db.dao.LSWBPDInstanceSharedUsageDAO;
import ru.ertelecom.bpms.db.entity.LSWBpdInstanceSharedUsage;

import java.util.List;

public class LSWBPDInstanceSharedUsageService {
    private final LSWBPDInstanceSharedUsageDAO lswbpdInstanceSharedUsageDAO = new LSWBPDInstanceSharedUsageDAO();

    public LSWBPDInstanceSharedUsageService() {}

    public List<LSWBpdInstanceSharedUsage> findByBpdInstanceId(final Long bpdInstanceId) {
        return lswbpdInstanceSharedUsageDAO.findByBpdInstanceId(bpdInstanceId);
    }
}
