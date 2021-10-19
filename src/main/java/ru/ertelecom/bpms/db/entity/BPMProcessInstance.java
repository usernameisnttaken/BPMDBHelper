package ru.ertelecom.bpms.db.entity;


import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Immutable
@Table(name = "LSW_BPD_INSTANCE")
public class BPMProcessInstance {
    // Id инстанса
    @Id
    @Column(name = "BPD_INSTANCE_ID")
    private Long bpdInstanceId;
    // Id снапшота
    @Column(name = "SNAPSHOT_ID")
    private String snapshotId;

    // Id приложения
    @Column(name = "PROJECT_ID", insertable = false, updatable = false)
    private String projectId;

    // Наименование инстанса
    @Column(name = "INSTANCE_NAME")
    private String instanceName;
    // Id статуса исполнения
    @Column(name = "EXECUTION_STATUS")
    private int executionStatusId;

    // Дата и время создания инстанса
    @Column(name = "CREATE_DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDatetime;
    // Дата и время контрольного срока
    @Column(name = "DUE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dueDatetime;
    // Дата и время последнего изменеения
    @Column(name = "LAST_MODIFIED_DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDatetime;

    // Проект
    @ManyToOne(targetEntity = BPMProject.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "PROJECT_ID", referencedColumnName = "PROJECT_ID")
    private BPMProject bpmProject;

    public BPMProcessInstance() {
    }

    @Override
    public String toString() {
        return "BPMProcessInstance{" +
                "bpdInstanceId=" + bpdInstanceId +
                ", snapshotId='" + snapshotId + '\'' +
                ", projectId='" + projectId + '\'' +
                ", instanceName='" + instanceName + '\'' +
                ", executionStatusId=" + executionStatusId +
                ", createDatetime=" + createDatetime +
                ", dueDatetime=" + dueDatetime +
                ", lastModifiedDatetime=" + lastModifiedDatetime +
                ", bpmProject=" + bpmProject +
                '}';
    }

    public Long getBpdInstanceId() {
        return bpdInstanceId;
    }

    public void setBpdInstanceId(Long bpdInstanceId) {
        this.bpdInstanceId = bpdInstanceId;
    }

    public String getSnapshotId() {
        return snapshotId;
    }

    public void setSnapshotId(String snapshotId) {
        this.snapshotId = snapshotId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getInstanceName() {
        return instanceName;
    }

    public void setInstanceName(String instanceName) {
        this.instanceName = instanceName;
    }

    public int getExecutionStatusId() {
        return executionStatusId;
    }

    public void setExecutionStatusId(int executionStatusId) {
        this.executionStatusId = executionStatusId;
    }

    public Date getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    public Date getDueDatetime() {
        return dueDatetime;
    }

    public void setDueDatetime(Date dueDatetime) {
        this.dueDatetime = dueDatetime;
    }

    public Date getLastModifiedDatetime() {
        return lastModifiedDatetime;
    }

    public void setLastModifiedDatetime(Date lastModifiedDatetime) {
        this.lastModifiedDatetime = lastModifiedDatetime;
    }

    public BPMProject getBpmProject() {
        return bpmProject;
    }

    public void setBpmProject(BPMProject bpmProject) {
        this.bpmProject = bpmProject;
    }
}
