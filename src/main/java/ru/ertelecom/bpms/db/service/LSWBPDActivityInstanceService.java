package ru.ertelecom.bpms.db.service;

import ru.ertelecom.bpms.db.dao.LSWBPDActivityInstanceDAO;
import ru.ertelecom.bpms.db.entity.LSWBPDActivityInstance;

import java.util.List;

public class LSWBPDActivityInstanceService {
    private final LSWBPDActivityInstanceDAO lswbpdActivityInstanceDAO = new LSWBPDActivityInstanceDAO();

    public LSWBPDActivityInstanceService() {}

    public List<LSWBPDActivityInstance> findByBPDInstanceId(final Long bpdInstanceId) {
        return lswbpdActivityInstanceDAO.findByBPDInstanceId(bpdInstanceId);
    }
}
