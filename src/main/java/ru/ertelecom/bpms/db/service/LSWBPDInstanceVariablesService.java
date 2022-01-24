package ru.ertelecom.bpms.db.service;

import ru.ertelecom.bpms.db.dao.LSWBPDInstanceVariablesDAO;
import ru.ertelecom.bpms.db.entity.LSWBPDInstanceVariables;

import java.util.List;

public class LSWBPDInstanceVariablesService {
    private final LSWBPDInstanceVariablesDAO lswbpdInstanceVariablesDAO = new LSWBPDInstanceVariablesDAO();

    public LSWBPDInstanceVariablesService() {}

    public List<LSWBPDInstanceVariables> findByBpdInstanceId(final Long bpdInstanceId) {
        return lswbpdInstanceVariablesDAO.findByBpdInstanceId(bpdInstanceId);
    }
}
