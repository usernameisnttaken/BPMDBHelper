package ru.ertelecom.bpms.db.entity;

import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.util.Date;

@Entity
@Immutable
@Table(name = "LSW_TASK")
public class BPMTaskInstance {
    // Id задачи
    @Id
    @Column(name = "TASK_ID")
    private Long taskId;
    // Наименование задачи
    @Column(name = "SUBJECT")
    private String subject;
    // Id инстанса, которому принадлежит задача
    @Column(name = "BPD_INSTANCE_ID", insertable = false, updatable = false)
    private Long bpdInstanceId;
    // Id типа активности
    @Column(name = "ACTIVITY_TASK_TYPE")
    private int activityTaskTypeId;
    // Id приоритета
    @Column(name = "PRIORITY_ID")
    private int priorityId;

    // Дата и время создания задачи
    @Column(name = "RCVD_DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date receivedDatetime;
    // Дата и время закрытия задачи
    @Column(name = "CLOSE_DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date closeDatetime;
    // Дата и время открытия задачи пользователем
    @Column(name = "READ_DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date readDatetime;
    // Дата и время последнего изменения
    @Column(name = "LAST_MODIFIED_DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDatetime;
    // Дата и время контрольного срока
    @Column(name = "DUE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dueDatetime;

    // Id пользователя, на которого назначена задача
    @Column(name = "USER_ID", insertable = false, updatable = false)
    private Long assignedToUserId;
    // Id группы, на которую назначена задача
    @Column(name = "GROUP_ID", insertable = false, updatable = false)
    private Long assignedToGroupId;
    // Id пользователя закрывшего задачу
    @Column(name = "CLOSE_BY", insertable = false, updatable = false)
    private Long closedByUserId;

    // Инстанс процесса
//    @ManyToOne(targetEntity = BPMProcessInstance.class, fetch = FetchType.LAZY)
//    @JoinColumn(name = "BPD_INSTANCE_ID", referencedColumnName = "BPD_INSTANCE_ID")
//    BPMProcessInstance bpmProcessInstance;

    // Пользователь, на которого назначена задача
//    @ManyToOne(targetEntity = BPMUser.class, fetch = FetchType.LAZY)
//    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
//    private BPMUser assignedToUser;
//    // Группа, на которого назначена задача
//    @ManyToOne(targetEntity = BPMGroup.class, fetch = FetchType.LAZY)
//    @JoinColumn(name = "GROUP_ID", referencedColumnName = "GROUP_ID")
//    private BPMUser assignedToGroup;
//    // Пользователь, закрывший задачу
//    @ManyToOne(targetEntity = BPMUser.class, fetch = FetchType.LAZY)
//    @JoinColumn(name = "CLOSE_BY", referencedColumnName = "USER_ID")
//    private BPMUser closedByUser;

    @Override
    public String toString() {
        return "BPMTaskInstance{" +
                "taskId=" + taskId +
                ", subject='" + subject + '\'' +
                ", bpdInstanceId=" + bpdInstanceId +
                ", activityTaskTypeId=" + activityTaskTypeId +
                ", priorityId=" + priorityId +
                ", receivedDatetime=" + receivedDatetime +
                ", closeDatetime=" + closeDatetime +
                ", readDatetime=" + readDatetime +
                ", lastModifiedDatetime=" + lastModifiedDatetime +
                ", dueDatetime=" + dueDatetime +
                ", assignedToUserId=" + assignedToUserId +
                ", assignedToGroupId=" + assignedToGroupId +
                ", closedByUserId=" + closedByUserId +
                '}';
    }

    public BPMTaskInstance() {
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Long getBpdInstanceId() {
        return bpdInstanceId;
    }

    public void setBpdInstanceId(Long bpdInstanceId) {
        this.bpdInstanceId = bpdInstanceId;
    }

    public int getActivityTaskTypeId() {
        return activityTaskTypeId;
    }

    public void setActivityTaskTypeId(int activityTaskTypeId) {
        this.activityTaskTypeId = activityTaskTypeId;
    }

    public int getPriorityId() {
        return priorityId;
    }

    public void setPriorityId(int priorityId) {
        this.priorityId = priorityId;
    }

    public Date getReceivedDatetime() {
        return receivedDatetime;
    }

    public void setReceivedDatetime(Date receivedDatetime) {
        this.receivedDatetime = receivedDatetime;
    }

    public Date getCloseDatetime() {
        return closeDatetime;
    }

    public void setCloseDatetime(Date closeDatetime) {
        this.closeDatetime = closeDatetime;
    }

    public Date getReadDatetime() {
        return readDatetime;
    }

    public void setReadDatetime(Date readDatetime) {
        this.readDatetime = readDatetime;
    }

    public Date getLastModifiedDatetime() {
        return lastModifiedDatetime;
    }

    public void setLastModifiedDatetime(Date lastModifiedDatetime) {
        this.lastModifiedDatetime = lastModifiedDatetime;
    }

    public Date getDueDatetime() {
        return dueDatetime;
    }

    public void setDueDatetime(Date dueDatetime) {
        this.dueDatetime = dueDatetime;
    }

    public Long getAssignedToUserId() {
        return assignedToUserId;
    }

    public void setAssignedToUserId(Long assignedToUserId) {
        this.assignedToUserId = assignedToUserId;
    }

    public Long getAssignedToGroupId() {
        return assignedToGroupId;
    }

    public void setAssignedToGroupId(Long assignedToGroupId) {
        this.assignedToGroupId = assignedToGroupId;
    }

    public Long getClosedByUserId() {
        return closedByUserId;
    }

    public void setClosedByUserId(Long closedByUserId) {
        this.closedByUserId = closedByUserId;
    }

}