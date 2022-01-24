package ru.ertelecom.bpms.db.entity;

import org.hibernate.annotations.Immutable;

import javax.persistence.*;


// TODO: у данной таблицы составной ПК - нужно реализовать, в тч и в архивной БД
@Entity
@Immutable
@Table(name = "LSW_TASK_FILE")
public class LSWTaskFile extends BPMDBEntity {
    @Column(name = "TASK_ID")
    private Long taskId;

    @Column(name = "SEQ")
    private Long seq;

    @Id
    @Column(name = "FILE_ID")
    private Long fileId;

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Long getSeq() {
        return seq;
    }

    public void setSeq(Long seq) {
        this.seq = seq;
    }

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    @Override
    public String toString() {
        return "LSWTaskFile{" +
                "taskId=" + taskId +
                ", seq=" + seq +
                ", fileId=" + fileId +
                '}';
    }
}

