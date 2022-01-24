package ru.ertelecom.bpms.db.entity;

import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.util.Date;

@Entity
@Immutable
@Table(name = "LSW_TASK")
public class LSWTask
    extends BPMDBEntity {
    // Id задачи
    @Id
    @Column(name = "TASK_ID")
    private Long taskId;

    // Снапшот = tip
    @Column(name = "TIP")
    private String tip;

    // Снапшот
    @Column(name = "SNAPSHOT_ID")
    private String snapshotId;

    // Id пользователя, на которого назначена задача
    @Column(name = "USER_ID", insertable = false, updatable = false)
    private Long userId;

    // Id группы, на которую назначена задача
    @Column(name = "GROUP_ID", insertable = false, updatable = false)
    private Long groupId;

    // Participant
    @Column(name = "PARTICIPANT_ID")
    private String participantId;

    // Managers group
    @Column(name = "MANAGERS_GROUP_ID")
    private Long managersGroupId;

    // Expert participant ref
    @Column(name = "EXPERT_PARTICIPANT_REF")
    private Long expertParticipantRef;

    // Status
    @Column(name = "STATUS")
    private String status;

    // Priority
    @Column(name = "PRIORITY_ID")
    private Long priorityId;

    // Дата и время контрольного срока
    @Column(name = "DUE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dueDate;

    // Due time
    @Column(name = "DUE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dueTime;

    // Due time
    @Column(name = "AT_RISK_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date atRiskDate;

    // Наименование задачи
    @Column(name = "SUBJECT")
    private String subject;

    // Дата и время создания задачи
    @Column(name = "RCVD_DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rcvdDatetime;

    // Rcvd from
    @Column(name = "RCVD_FROM")
    private Long rcvdFrom;

    // Rcvd task id
    @Column(name = "RCVD_TASK_ID")
    private Long rcvdTaskId;

    // Collaboration
    @Column(name = "COLLABORATION")
    private String collaboration;

    // Sent datetime
    @Column(name = "SENT_DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sentDatetime;

    // Дата и время открытия задачи пользователем
    @Column(name = "READ_DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date readDatetime;

    // Дата и время закрытия задачи
    @Column(name = "CLOSE_DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date closeDatetime;

    // Id пользователя закрывшего задачу
    @Column(name = "CLOSE_BY", insertable = false, updatable = false)
    private Long closedByUserId;

    // Orig task id
    @Column(name = "ORIG_TASK_ID")
    private Long origTaskId;

    // Start process ref
    @Column(name = "START_PROCESS_REF")
    private Long startProcessRef;

    // Cached process version id
    @Column(name = "CACHED_PROCESS_VERSION_ID")
    private String cachedProcessVersionId;

    // Group id type
    @Column(name = "GROUP_ID_TYPE")
    private Long groupIdType;

    // Execution status
    @Column(name = "EXECUTION_STATUS")
    private Long executionStatus;

    // Id инстанса, которому принадлежит задача
    @Column(name = "BPD_INSTANCE_ID", insertable = false, updatable = false)
    private Long bpdInstanceId;

    // Created by bpd ref
    @Column(name = "CREATED_BY_BPD_REF")
    private Long createdByBPDRef;

    // Cached cbb version id
    @Column(name = "CACHED_CBB_VERSION_ID")
    private String cachedCBBVersionId;

    // Created by bpd flow object id
    @Column(name = "CREATED_BY_BPD_FLOW_OBJECT_ID")
    private String createdByBPDFlowObjectId;

    // Assumer id
    @Column(name = "ASSUMER_ID")
    private Long assumerId;

    // Attached form ref
    @Column(name = "ATTACHED_FORM_REF")
    private Long attachedFormRef;

    // Cached form version id
    @Column(name = "CACHED_FORM_VERSION_ID")
    private String cachedFormVersionId;

    // Attached ext activity ref
    @Column(name = "ATTACHED_EXT_ACTIVITY_REF")
    private Long attachedExtActivityRef;

    // Cached extact version id
    @Column(name = "CACHED_EXTACT_VERSION_ID")
    private String cachedExtactVersionId;

    // Sharepoint discussion url
    @Column(name = "SHAREPOINT_DISCUSSION_URL")
    private String sharepointDiscussionUrl;

    // ActivityName
    @Column(name = "ACTIVITY_NAME")
    private String activityName;

    // Id типа активности
    @Column(name = "ACTIVITY_TASK_TYPE")
    private Integer activityTaskType;

    // Дата и время последнего изменения
    @Column(name = "LAST_MODIFIED_DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDatetime;

    // Field1
    @Column(name = "FIELD1")
    private String field1;

    // Field2
    @Column(name = "FIELD2")
    private Long field2;

    // Field3
    @Column(name = "FIELD3")
    private String field3;

    // Field4
    @Column(name = "FIELD4")
    private String field4;

    // Field5
    @Column(name = "FIELD5")
    private String field5;

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getSnapshotId() {
        return snapshotId;
    }

    public void setSnapshotId(String snapshotId) {
        this.snapshotId = snapshotId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getParticipantId() {
        return participantId;
    }

    public void setParticipantId(String participantId) {
        this.participantId = participantId;
    }

    public Long getManagersGroupId() {
        return managersGroupId;
    }

    public void setManagersGroupId(Long managersGroupId) {
        this.managersGroupId = managersGroupId;
    }

    public Long getExpertParticipantRef() {
        return expertParticipantRef;
    }

    public void setExpertParticipantRef(Long expertParticipantRef) {
        this.expertParticipantRef = expertParticipantRef;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getPriorityId() {
        return priorityId;
    }

    public void setPriorityId(Long priorityId) {
        this.priorityId = priorityId;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getDueTime() {
        return dueTime;
    }

    public void setDueTime(Date dueTime) {
        this.dueTime = dueTime;
    }

    public Date getAtRiskDate() {
        return atRiskDate;
    }

    public void setAtRiskDate(Date atRiskDate) {
        this.atRiskDate = atRiskDate;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Date getRcvdDatetime() {
        return rcvdDatetime;
    }

    public void setRcvdDatetime(Date rcvdDatetime) {
        this.rcvdDatetime = rcvdDatetime;
    }

    public Long getRcvdFrom() {
        return rcvdFrom;
    }

    public void setRcvdFrom(Long rcvdFrom) {
        this.rcvdFrom = rcvdFrom;
    }

    public Long getRcvdTaskId() {
        return rcvdTaskId;
    }

    public void setRcvdTaskId(Long rcvdTaskId) {
        this.rcvdTaskId = rcvdTaskId;
    }

    public String getCollaboration() {
        return collaboration;
    }

    public void setCollaboration(String collaboration) {
        this.collaboration = collaboration;
    }

    public Date getSentDatetime() {
        return sentDatetime;
    }

    public void setSentDatetime(Date sentDatetime) {
        this.sentDatetime = sentDatetime;
    }

    public Date getReadDatetime() {
        return readDatetime;
    }

    public void setReadDatetime(Date readDatetime) {
        this.readDatetime = readDatetime;
    }

    public Date getCloseDatetime() {
        return closeDatetime;
    }

    public void setCloseDatetime(Date closeDatetime) {
        this.closeDatetime = closeDatetime;
    }

    public Long getClosedByUserId() {
        return closedByUserId;
    }

    public void setClosedByUserId(Long closedByUserId) {
        this.closedByUserId = closedByUserId;
    }

    public Long getOrigTaskId() {
        return origTaskId;
    }

    public void setOrigTaskId(Long origTaskId) {
        this.origTaskId = origTaskId;
    }

    public Long getStartProcessRef() {
        return startProcessRef;
    }

    public void setStartProcessRef(Long startProcessRef) {
        this.startProcessRef = startProcessRef;
    }

    public String getCachedProcessVersionId() {
        return cachedProcessVersionId;
    }

    public void setCachedProcessVersionId(String cachedProcessVersionId) {
        this.cachedProcessVersionId = cachedProcessVersionId;
    }

    public Long getGroupIdType() {
        return groupIdType;
    }

    public void setGroupIdType(Long groupIdType) {
        this.groupIdType = groupIdType;
    }

    public Long getExecutionStatus() {
        return executionStatus;
    }

    public void setExecutionStatus(Long executionStatus) {
        this.executionStatus = executionStatus;
    }

    public Long getBpdInstanceId() {
        return bpdInstanceId;
    }

    public void setBpdInstanceId(Long bpdInstanceId) {
        this.bpdInstanceId = bpdInstanceId;
    }

    public Long getCreatedByBPDRef() {
        return createdByBPDRef;
    }

    public void setCreatedByBPDRef(Long createdByBPDRef) {
        this.createdByBPDRef = createdByBPDRef;
    }

    public String getCachedCBBVersionId() {
        return cachedCBBVersionId;
    }

    public void setCachedCBBVersionId(String cachedCBBVersionId) {
        this.cachedCBBVersionId = cachedCBBVersionId;
    }

    public String getCreatedByBPDFlowObjectId() {
        return createdByBPDFlowObjectId;
    }

    public void setCreatedByBPDFlowObjectId(String createdByBPDFlowObjectId) {
        this.createdByBPDFlowObjectId = createdByBPDFlowObjectId;
    }

    public Long getAssumerId() {
        return assumerId;
    }

    public void setAssumerId(Long assumerId) {
        this.assumerId = assumerId;
    }

    public Long getAttachedFormRef() {
        return attachedFormRef;
    }

    public void setAttachedFormRef(Long attachedFormRef) {
        this.attachedFormRef = attachedFormRef;
    }

    public String getCachedFormVersionId() {
        return cachedFormVersionId;
    }

    public void setCachedFormVersionId(String cachedFormVersionId) {
        this.cachedFormVersionId = cachedFormVersionId;
    }

    public Long getAttachedExtActivityRef() {
        return attachedExtActivityRef;
    }

    public void setAttachedExtActivityRef(Long attachedExtActivityRef) {
        this.attachedExtActivityRef = attachedExtActivityRef;
    }

    public String getCachedExtactVersionId() {
        return cachedExtactVersionId;
    }

    public void setCachedExtactVersionId(String cachedExtactVersionId) {
        this.cachedExtactVersionId = cachedExtactVersionId;
    }

    public String getSharepointDiscussionUrl() {
        return sharepointDiscussionUrl;
    }

    public void setSharepointDiscussionUrl(String sharepointDiscussionUrl) {
        this.sharepointDiscussionUrl = sharepointDiscussionUrl;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public Integer getActivityTaskType() {
        return activityTaskType;
    }

    public void setActivityTaskType(Integer activityTaskType) {
        this.activityTaskType = activityTaskType;
    }

    public Date getLastModifiedDatetime() {
        return lastModifiedDatetime;
    }

    public void setLastModifiedDatetime(Date lastModifiedDatetime) {
        this.lastModifiedDatetime = lastModifiedDatetime;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public Long getField2() {
        return field2;
    }

    public void setField2(Long field2) {
        this.field2 = field2;
    }

    public String getField3() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3 = field3;
    }

    public String getField4() {
        return field4;
    }

    public void setField4(String field4) {
        this.field4 = field4;
    }

    public String getField5() {
        return field5;
    }

    public void setField5(String field5) {
        this.field5 = field5;
    }

    @Override
    public String toString() {
        return "LSWTask{" +
                "taskId=" + taskId +
                ", tip='" + tip + '\'' +
                ", snapshotId='" + snapshotId + '\'' +
                ", userId=" + userId +
                ", groupId=" + groupId +
                ", participantId='" + participantId + '\'' +
                ", managersGroupId=" + managersGroupId +
                ", expertParticipantRef=" + expertParticipantRef +
                ", status='" + status + '\'' +
                ", priorityId=" + priorityId +
                ", dueDate=" + dueDate +
                ", dueTime=" + dueTime +
                ", atRiskDate=" + atRiskDate +
                ", subject='" + subject + '\'' +
                ", rcvdDatetime=" + rcvdDatetime +
                ", rcvdFrom=" + rcvdFrom +
                ", rcvdTaskId=" + rcvdTaskId +
                ", collaboration='" + collaboration + '\'' +
                ", sentDatetime=" + sentDatetime +
                ", readDatetime=" + readDatetime +
                ", closeDatetime=" + closeDatetime +
                ", closedByUserId=" + closedByUserId +
                ", origTaskId=" + origTaskId +
                ", startProcessRef=" + startProcessRef +
                ", cachedProcessVersionId='" + cachedProcessVersionId + '\'' +
                ", groupIdType=" + groupIdType +
                ", executionStatus=" + executionStatus +
                ", bpdInstanceId=" + bpdInstanceId +
                ", createdByBPDRef=" + createdByBPDRef +
                ", cachedCBBVersionId='" + cachedCBBVersionId + '\'' +
                ", createdByBPDFlowObjectId='" + createdByBPDFlowObjectId + '\'' +
                ", assumerId=" + assumerId +
                ", attachedFormRef=" + attachedFormRef +
                ", cachedFormVersionId='" + cachedFormVersionId + '\'' +
                ", attachedExtActivityRef=" + attachedExtActivityRef +
                ", cachedExtactVersionId='" + cachedExtactVersionId + '\'' +
                ", sharepointDiscussionUrl='" + sharepointDiscussionUrl + '\'' +
                ", activityName='" + activityName + '\'' +
                ", activityTaskType=" + activityTaskType +
                ", lastModifiedDatetime=" + lastModifiedDatetime +
                ", field1='" + field1 + '\'' +
                ", field2=" + field2 +
                ", field3='" + field3 + '\'' +
                ", field4='" + field4 + '\'' +
                ", field5='" + field5 + '\'' +
                '}';
    }
}