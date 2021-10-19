package ru.ertelecom.bpms.db.service;

import ru.ertelecom.bpms.db.dao.BPMProjectDAO;
import ru.ertelecom.bpms.db.entity.BPMProject;

public class BPMProjectService {
    private BPMProjectDAO bpmProjectDAO = new BPMProjectDAO();

    public BPMProjectService() {
    }
     public BPMProject findByAcronym(final String acronym) {
        return bpmProjectDAO.findByAcronym(acronym);
     }
}
