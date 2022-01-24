package ru.ertelecom.bpms.db.entity;


import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Immutable
@Table(name = "LSW_TASK_ADDR")
public class LSWTaskAddr extends BPMDBEntity {
    @Id
    @Column(name = "TASK_ADDR_ID")
    private Long taskAddrId;

    @Column(name = "TASK_ID")
    private Long taskId;

    @Column(name = "SEQ")
    private Long seq;

    @Column(name = "SEND_TO_ID")
    private String sendToId;

    @Override
    public String toString() {
        return "LSWTaskAddr{" +
                "taskAddrId=" + taskAddrId +
                ", taskId=" + taskId +
                ", seq=" + seq +
                ", sendToId='" + sendToId + '\'' +
                '}';
    }

    public Long getTaskAddrId() {
        return taskAddrId;
    }

    public void setTaskAddrId(Long taskAddrId) {
        this.taskAddrId = taskAddrId;
    }

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

    public String getSendToId() {
        return sendToId;
    }

    public void setSendToId(String sendToId) {
        this.sendToId = sendToId;
    }
}
