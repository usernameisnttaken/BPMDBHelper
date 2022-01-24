package ru.ertelecom.bpms.db.service;

import ru.ertelecom.bpms.db.dao.LSWBPDInstanceExtDataDAO;
import ru.ertelecom.bpms.db.entity.LSWBPDInstanceExtData;

import java.util.List;

public class LSWBPDInstanceExtDataService {
    private final LSWBPDInstanceExtDataDAO lswbpdInstanceExtDataDAO = new LSWBPDInstanceExtDataDAO();

    public LSWBPDInstanceExtDataService() {}

    public List<LSWBPDInstanceExtData> findByBpdInstanceId(final Long bpdInstanceId) {
        return lswbpdInstanceExtDataDAO.findByBPDInstanceId(bpdInstanceId);
    }
}
