package ru.ertelecom.bpms.db.service;

import ru.ertelecom.bpms.db.dao.LSWGrpGrpMemXrefDAO;
import ru.ertelecom.bpms.db.entity.LSWGrpGrpMemXref;

import java.util.List;

public class LSWGrpGrpMemXrefService {
    private final LSWGrpGrpMemXrefDAO lswGrpGrpMemXrefDAO = new LSWGrpGrpMemXrefDAO();

    public LSWGrpGrpMemXrefService() {}

    public List<LSWGrpGrpMemXref> findByGroupId(final Long groupId) {
        return lswGrpGrpMemXrefDAO.findByGroupId(groupId);
    }
}
