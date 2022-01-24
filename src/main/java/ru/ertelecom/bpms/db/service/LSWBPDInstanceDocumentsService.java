package ru.ertelecom.bpms.db.service;

import ru.ertelecom.bpms.db.dao.LSWBPDInstanceDocumentsDAO;
import ru.ertelecom.bpms.db.entity.LSWBPDInstanceDocuments;

import java.util.List;

public class LSWBPDInstanceDocumentsService {
    private final LSWBPDInstanceDocumentsDAO lswbpdInstanceDocumentsDAO = new LSWBPDInstanceDocumentsDAO();

    public LSWBPDInstanceDocumentsService() {}

    public List<LSWBPDInstanceDocuments> findByBpdInstanceId(final Long bpdInstanceId) {
        return lswbpdInstanceDocumentsDAO.findByBPDInstanceId(bpdInstanceId);
    }
}
