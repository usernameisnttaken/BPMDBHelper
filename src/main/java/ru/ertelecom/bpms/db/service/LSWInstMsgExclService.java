package ru.ertelecom.bpms.db.service;

import ru.ertelecom.bpms.db.dao.LSWInstMsgExclDAO;
import ru.ertelecom.bpms.db.entity.LSWInstMsgExcl;

import java.util.List;

public class LSWInstMsgExclService {
    private final LSWInstMsgExclDAO lswInstMsgExclDAO = new LSWInstMsgExclDAO();

    public LSWInstMsgExclService() {}

    public List<LSWInstMsgExcl> findByBpdInstanceId(final Long bpdInstanceId) {
        return lswInstMsgExclDAO.findByBpdInstanceId(bpdInstanceId);
    }
}
