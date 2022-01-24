package ru.ertelecom.bpms.db.service;

import ru.ertelecom.bpms.db.dao.LSWRuntimeErrorDAO;
import ru.ertelecom.bpms.db.entity.LSWRuntimeError;

import java.util.List;

public class LSWRuntimeErrorService {
    private final LSWRuntimeErrorDAO lswRuntimeErrorDAO = new LSWRuntimeErrorDAO();

    public LSWRuntimeErrorService() {}

    public List<LSWRuntimeError> findByBpdInstanceId(final Long bpdInstanceId) {
        return lswRuntimeErrorDAO.findByBPDInstanceId(bpdInstanceId);
    }
}
