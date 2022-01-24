package ru.ertelecom.bpms.db.service;

import ru.ertelecom.bpms.db.dao.BPMECMObjectDAO;
import ru.ertelecom.bpms.db.entity.BPMECMObject;

import java.util.List;

public class BPMECMObjectService {
    private final BPMECMObjectDAO bpmecmObjectDAO = new BPMECMObjectDAO();

    public BPMECMObjectService() {
    }

    public List<BPMECMObject> findByBPDInstanceId(final Long bpdInstanceId) {
        return bpmecmObjectDAO.findByBPDInstanceId(bpdInstanceId);
    }
}
