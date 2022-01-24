package ru.ertelecom.bpms.db.service;

import ru.ertelecom.bpms.db.dao.LSWUsrGrpMemXrefDAO;
import ru.ertelecom.bpms.db.entity.LSWUsrGrpMemXref;

import java.util.List;

public class LSWUsrGrpMemXrefService {
    private final LSWUsrGrpMemXrefDAO lswUsrGrpMemXrefDAO = new LSWUsrGrpMemXrefDAO();

    public LSWUsrGrpMemXrefService() {}

    public List<LSWUsrGrpMemXref> findByUserId(final Long userId) {
        return lswUsrGrpMemXrefDAO.findByUserId(userId);
    }

    public List<LSWUsrGrpMemXref> findByGroupId(final Long groupId) {
        return lswUsrGrpMemXrefDAO.findByGroupId(groupId);
    }

    public LSWUsrGrpMemXref findByUserIdAndGroupId(final Long userId, final Long groupId) {
        return lswUsrGrpMemXrefDAO.findByUserIdAndGroupId(userId, groupId);
    }
}
