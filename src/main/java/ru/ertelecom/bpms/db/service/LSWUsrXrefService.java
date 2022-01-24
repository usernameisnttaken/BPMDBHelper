package ru.ertelecom.bpms.db.service;

import ru.ertelecom.bpms.db.dao.LSWUsrXrefDAO;
import ru.ertelecom.bpms.db.entity.LSWUsrXref;

import java.util.List;

public class LSWUsrXrefService {
    private final LSWUsrXrefDAO LSWUsrXrefDAO = new LSWUsrXrefDAO();

    public LSWUsrXrefService() {
    }

    public LSWUsrXref findByUserId(final Long userId) {
        return LSWUsrXrefDAO.findByUserId(userId);
    }

    public List<LSWUsrXref> findAll() {
        return LSWUsrXrefDAO.findAll();
    }
}
