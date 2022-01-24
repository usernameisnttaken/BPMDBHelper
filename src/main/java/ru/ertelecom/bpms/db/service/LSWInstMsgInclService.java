package ru.ertelecom.bpms.db.service;

import ru.ertelecom.bpms.db.dao.LSWInstMsgInclDAO;
import ru.ertelecom.bpms.db.entity.LSWInstMsgIncl;

import java.util.List;

public class LSWInstMsgInclService {
    private final LSWInstMsgInclDAO lswInstMsgInclDAO = new LSWInstMsgInclDAO();

    public LSWInstMsgInclService() {}

    public List<LSWInstMsgIncl> finByBpdInstanceId(final Long bpdInstanceId) {
        return lswInstMsgInclDAO.findByBpdInstanceId(bpdInstanceId);
    }
}
