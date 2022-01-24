package ru.ertelecom.bpms.db.service;

import ru.ertelecom.bpms.db.dao.LSWTaskNarrDAO;
import ru.ertelecom.bpms.db.entity.LSWTaskNarr;

import java.util.List;


public class LSWTaskNarrService {
    private final LSWTaskNarrDAO LSWTaskNarrDAO = new LSWTaskNarrDAO();

    public LSWTaskNarrService() {
    }

    public LSWTaskNarr findByTaskNarrId(final Long taskNarrId) {
        return LSWTaskNarrDAO.findByTaskNarrId(taskNarrId);
    }

    public List<LSWTaskNarr> findByTaskId(final Long taskId) { return LSWTaskNarrDAO.findByTaskId(taskId); }

}
