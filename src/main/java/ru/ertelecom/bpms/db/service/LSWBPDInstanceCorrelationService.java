package ru.ertelecom.bpms.db.service;

import ru.ertelecom.bpms.db.dao.LSWBPDInstanceCorrelationDAO;
import ru.ertelecom.bpms.db.entity.LSWBPDInstanceCorrelation;

import java.util.List;

public class LSWBPDInstanceCorrelationService {
    private final LSWBPDInstanceCorrelationDAO lswbpdInstanceCorrelationDAO = new LSWBPDInstanceCorrelationDAO();

    public LSWBPDInstanceCorrelationService() {}

    public List<LSWBPDInstanceCorrelation> findByBPDInstanceId(final Long bpdInstanceId) {
        return lswbpdInstanceCorrelationDAO.findByBPDInstanceId(bpdInstanceId);
    }
}
