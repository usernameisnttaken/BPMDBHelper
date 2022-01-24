package ru.ertelecom.bpms.db.entity;

import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.util.Arrays;


@Entity
@Immutable
@Table(name = "LSW_TASK_IPF_DATA")
public class LSWTaskIpfData
    extends BPMDBEntity {
    @Id
    @Column(name = "TASK_INFOPATHFORM_DATA_ID")
    private Long taskInfopathformDataId;

    @Column(name = "TASK_ID")
    private Long taskId;

    @Column(name = "INFOPATH_FORM_REF")
    private String infopathFormRef;

    @Lob
    @Column(name = "DATA")
    private byte[] data;

    @Override
    public String toString() {
        return "LSWTaskIpfData{" +
                "taskInfopathformDataId=" + taskInfopathformDataId +
                ", taskId=" + taskId +
                ", infopathFormRef='" + infopathFormRef + '\'' +
                ", data=" + Arrays.toString(data) +
                '}';
    }

    public Long getTaskInfopathformDataId() {
        return taskInfopathformDataId;
    }

    public void setTaskInfopathformDataId(Long taskInfopathformDataId) {
        this.taskInfopathformDataId = taskInfopathformDataId;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getInfopathFormRef() {
        return infopathFormRef;
    }

    public void setInfopathFormRef(String infopathFormRef) {
        this.infopathFormRef = infopathFormRef;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
