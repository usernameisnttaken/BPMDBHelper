package ru.ertelecom.bpms.db.service;

import ru.ertelecom.bpms.db.dao.LSWUserGrpXrefDAO;
import ru.ertelecom.bpms.db.entity.LSWUsrGrpXref;

public class LSWUsrGrpXrefService {
    private final LSWUserGrpXrefDAO LSWUserGrpXrefDAO = new LSWUserGrpXrefDAO();

    public LSWUsrGrpXrefService() {
    }

    public LSWUsrGrpXref findByGroupId(final Long groupId) {
        return LSWUserGrpXrefDAO.findByGroupId(groupId);
    }
}
