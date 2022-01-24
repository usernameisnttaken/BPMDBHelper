package ru.ertelecom.bpms.db.entity;

import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.util.Arrays;


@Entity
@Immutable
@Table(name = "LSW_TASK_EXTACT_DATA")
public class LSWTaskExtactData
    extends BPMDBEntity {
    @Id
    @Column(name = "TASK_EXTACT_DATA_ID")
    private Long taskExtactDataId;

    @Column(name = "TASK_ID")
    private Long taskId;

    @Column(name = "EXTERNAL_ACTIVITY_REF")
    private String externalActivityRef;

    @Lob
    @Column(name = "DATA")
    private byte[] data;

    public Long getTaskExtactDataId() {
        return taskExtactDataId;
    }

    public void setTaskExtactDataId(Long taskExtactDataId) {
        this.taskExtactDataId = taskExtactDataId;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getExternalActivityRef() {
        return externalActivityRef;
    }

    public void setExternalActivityRef(String externalActivityRef) {
        this.externalActivityRef = externalActivityRef;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "LSWTaskExtactData{" +
                "taskExtactDataId=" + taskExtactDataId +
                ", taskId=" + taskId +
                ", externalActivityRef='" + externalActivityRef + '\'' +
                ", data=" + Arrays.toString(data) +
                '}';
    }
}
