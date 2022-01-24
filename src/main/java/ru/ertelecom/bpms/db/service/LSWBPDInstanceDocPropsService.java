package ru.ertelecom.bpms.db.service;

import ru.ertelecom.bpms.db.dao.LSWBPDInstanceDocPropsDAO;
import ru.ertelecom.bpms.db.entity.LSWBPDInstanceDocProps;

import java.util.List;

public class LSWBPDInstanceDocPropsService {
    private final LSWBPDInstanceDocPropsDAO lswbpdInstanceDocPropsDAO = new LSWBPDInstanceDocPropsDAO();

    public LSWBPDInstanceDocPropsService() {}

    public List<LSWBPDInstanceDocProps> findByDocId(final Long docId) {
        return lswbpdInstanceDocPropsDAO.findByDocId(docId);
    }
}
