package ru.ertelecom.bpms.db.service;

import ru.ertelecom.bpms.db.dao.LSWGrpGrpMemExplodedXrefDAO;
import ru.ertelecom.bpms.db.entity.LSWGrpGrpMemExplodedXref;

import java.util.List;

public class LSWGrpGrpMemExplodedXrefService {
    private final LSWGrpGrpMemExplodedXrefDAO lswGrpGrpMemExplodedXrefDAO = new LSWGrpGrpMemExplodedXrefDAO();

    public LSWGrpGrpMemExplodedXrefService() {}

    public List<LSWGrpGrpMemExplodedXref> findByGroupId(final Long groupId) {
        return lswGrpGrpMemExplodedXrefDAO.findByGroupId(groupId);
    }
}
