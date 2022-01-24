package ru.ertelecom.bpms.db.service;

import ru.ertelecom.bpms.db.dao.LSWTaskFileDAO;
import ru.ertelecom.bpms.db.entity.LSWTaskFile;

import java.util.List;

public class LSWTaskFileService {
    private final LSWTaskFileDAO LSWTaskFileDAO = new LSWTaskFileDAO();

    public LSWTaskFileService() {
    }

    public List<LSWTaskFile> findByTaskId(final Long taskId) {
        return LSWTaskFileDAO.findByTaskId(taskId);
    }
}
