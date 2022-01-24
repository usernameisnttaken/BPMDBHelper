package ru.ertelecom.bpms.db.entity;


import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.util.Date;

@Entity
@Immutable
@Table(name = "LSW_BPD_INSTANCE")
public class LSWBpdInstance
    extends BPMDBEntity {
    // Id инстанса
    @Id
    @Column(name = "BPD_INSTANCE_ID")
    private Long bpdInstanceId;

    // Наименование инстанса
    @Column(name = "INSTANCE_NAME")
    private String instanceName;

    @Column(name = "BPD_REF")
    private Long bpdRef;

    @Column(name = "CACHED_BPD_VERSION_ID")
    private String cachedBPDVersionId;

    // Дата и время создания инстанса
    @Column(name = "CREATE_DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDatetime;

    // Дата и время контрольного срока
    @Column(name = "DUE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dueDate;

    // Дата и время последнего изменеения
    @Column(name = "LAST_MODIFIED_DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDatetime;

    @Column(name = "SAVE_SEQ")
    private Long saveSeq;

    // Id статуса исполнения
    @Column(name = "EXECUTION_STATUS")
    private Integer executionStatus;

    @Column(name = "ERROR")
    private String error;

    @Column(name = "ERROR_STACK_TRACE")
    private String errorStackTrace;

    @Column(name = "SHAREPOINT_SITE_URL")
    private String sharepointSiteUrl;

    @Column(name = "TIP")
    private String tip;

    // Id снапшота
    @Column(name = "SNAPSHOT_ID")
    private String snapshotId;

    @Column(name = "AT_RISK_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date atRiskDate;

    @Column(name = "ATTACHMENT_STORE")
    private Integer attachmentStore;

    // Дата и время закрытия инстанса
    @Column(name = "CLOSE_DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date closeDatetime;

    @Column(name = "GROUP_ID")
    private Long groupId;

    @Column(name = "CASE_FOLDER_ID")
    private String caseFolderId;

    @Column(name = "CASE_FOLDER_SERVER_NAME")
    private String caseFolderServerName;

    @Column(name = "SECURITY_FOLDER_ID")
    private String securityFolderId;

    @Column(name = "STARTING_DOCUMENT_ID")
    private String startingDocumentId;

    @Column(name = "STARTING_DOCUMENT_SERVER_NAME")
    private String satrterDocumentServerName;

    @Column(name = "PARENT_CASE_ID")
    private String parentCaseId;

    @Column(name = "PARENT_ACTIVITY_ID")
    private String parentActivityId;

    @Column(name = "WORKFLOW_APPLICATION")
    private String workflowApplication;

    @Column(name = "OWNER_GROUP_ID")
    private Long ownerGroupId;

    @Column(name = "DOCUMENTS_STATE")
    private Integer documentsState;

    // Пользователь, запустивший инстанс
    @Column(name = "STARTER_ID")
    private Long starterId;

    // Id приложения
    @Column(name = "PROJECT_ID")
    private String projectId;

    @Column(name = "BPD_NAME")
    private String bpdName;

    @Column(name = "SBO_SYNC_ENABLED")
    private String sboSyncEnabled;

    @Column(name = "CAN_DELETE_INSTANCE")
    private String canDeleteInstance;

    @Column(name = "FIELD1")
    private String field1;

    @Column(name = "FIELD2")
    private Long field2;

    @Column(name = "FIELD3")
    private String field3;

    @Column(name = "FIELD4")
    private String field4;

    @Column(name = "FIELD5")
    private String field5;

    public Long getBpdInstanceId() {
        return bpdInstanceId;
    }

    public void setBpdInstanceId(Long bpdInstanceId) {
        this.bpdInstanceId = bpdInstanceId;
    }

    public String getInstanceName() {
        return instanceName;
    }

    public void setInstanceName(String instanceName) {
        this.instanceName = instanceName;
    }

    public Long getBpdRef() {
        return bpdRef;
    }

    public void setBpdRef(Long bpdRef) {
        this.bpdRef = bpdRef;
    }

    public String getCachedBPDVersionId() {
        return cachedBPDVersionId;
    }

    public void setCachedBPDVersionId(String cachedBPDVersionId) {
        this.cachedBPDVersionId = cachedBPDVersionId;
    }

    public Date getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getLastModifiedDatetime() {
        return lastModifiedDatetime;
    }

    public void setLastModifiedDatetime(Date lastModifiedDatetime) {
        this.lastModifiedDatetime = lastModifiedDatetime;
    }

    public Long getSaveSeq() {
        return saveSeq;
    }

    public void setSaveSeq(Long saveSeq) {
        this.saveSeq = saveSeq;
    }

    public Integer getExecutionStatus() {
        return executionStatus;
    }

    public void setExecutionStatus(Integer executionStatus) {
        this.executionStatus = executionStatus;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getErrorStackTrace() {
        return errorStackTrace;
    }

    public void setErrorStackTrace(String errorStackTrace) {
        this.errorStackTrace = errorStackTrace;
    }

    public String getSharepointSiteUrl() {
        return sharepointSiteUrl;
    }

    public void setSharepointSiteUrl(String sharepointSiteUrl) {
        this.sharepointSiteUrl = sharepointSiteUrl;
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

    public Date getAtRiskDate() {
        return atRiskDate;
    }

    public void setAtRiskDate(Date atRiskDate) {
        this.atRiskDate = atRiskDate;
    }

    public Integer getAttachmentStore() {
        return attachmentStore;
    }

    public void setAttachmentStore(Integer attachmentStore) {
        this.attachmentStore = attachmentStore;
    }

    public Date getCloseDatetime() {
        return closeDatetime;
    }

    public void setCloseDatetime(Date closeDatetime) {
        this.closeDatetime = closeDatetime;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getCaseFolderId() {
        return caseFolderId;
    }

    public void setCaseFolderId(String caseFolderId) {
        this.caseFolderId = caseFolderId;
    }

    public String getCaseFolderServerName() {
        return caseFolderServerName;
    }

    public void setCaseFolderServerName(String caseFolderServerName) {
        this.caseFolderServerName = caseFolderServerName;
    }

    public String getSecurityFolderId() {
        return securityFolderId;
    }

    public void setSecurityFolderId(String securityFolderId) {
        this.securityFolderId = securityFolderId;
    }

    public String getStartingDocumentId() {
        return startingDocumentId;
    }

    public void setStartingDocumentId(String startingDocumentId) {
        this.startingDocumentId = startingDocumentId;
    }

    public String getSatrterDocumentServerName() {
        return satrterDocumentServerName;
    }

    public void setSatrterDocumentServerName(String satrterDocumentServerName) {
        this.satrterDocumentServerName = satrterDocumentServerName;
    }

    public String getParentCaseId() {
        return parentCaseId;
    }

    public void setParentCaseId(String parentCaseId) {
        this.parentCaseId = parentCaseId;
    }

    public String getParentActivityId() {
        return parentActivityId;
    }

    public void setParentActivityId(String parentActivityId) {
        this.parentActivityId = parentActivityId;
    }

    public String getWorkflowApplication() {
        return workflowApplication;
    }

    public void setWorkflowApplication(String workflowApplication) {
        this.workflowApplication = workflowApplication;
    }

    public Long getOwnerGroupId() {
        return ownerGroupId;
    }

    public void setOwnerGroupId(Long ownerGroupId) {
        this.ownerGroupId = ownerGroupId;
    }

    public Integer getDocumentsState() {
        return documentsState;
    }

    public void setDocumentsState(Integer documentsState) {
        this.documentsState = documentsState;
    }

    public Long getStarterId() {
        return starterId;
    }

    public void setStarterId(Long starterId) {
        this.starterId = starterId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getBpdName() {
        return bpdName;
    }

    public void setBpdName(String bpdName) {
        this.bpdName = bpdName;
    }

    public String getSboSyncEnabled() {
        return sboSyncEnabled;
    }

    public void setSboSyncEnabled(String sboSyncEnabled) {
        this.sboSyncEnabled = sboSyncEnabled;
    }

    public String getCanDeleteInstance() {
        return canDeleteInstance;
    }

    public void setCanDeleteInstance(String canDeleteInstance) {
        this.canDeleteInstance = canDeleteInstance;
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
        return "LSWBpdInstance{" +
                "bpdInstanceId=" + bpdInstanceId +
                ", instanceName='" + instanceName + '\'' +
                ", bpdRef=" + bpdRef +
                ", cachedBPDVersionId='" + cachedBPDVersionId + '\'' +
                ", createDatetime=" + createDatetime +
                ", dueDate=" + dueDate +
                ", lastModifiedDatetime=" + lastModifiedDatetime +
                ", saveSeq=" + saveSeq +
                ", executionStatus=" + executionStatus +
                ", error='" + error + '\'' +
                ", errorStackTrace='" + errorStackTrace + '\'' +
                ", sharepointSiteUrl='" + sharepointSiteUrl + '\'' +
                ", tip='" + tip + '\'' +
                ", snapshotId='" + snapshotId + '\'' +
                ", atRiskDate=" + atRiskDate +
                ", attachmentStore=" + attachmentStore +
                ", closeDatetime=" + closeDatetime +
                ", groupId=" + groupId +
                ", caseFolderId='" + caseFolderId + '\'' +
                ", caseFolderServerName='" + caseFolderServerName + '\'' +
                ", securityFolderId='" + securityFolderId + '\'' +
                ", startingDocumentId='" + startingDocumentId + '\'' +
                ", satrterDocumentServerName='" + satrterDocumentServerName + '\'' +
                ", parentCaseId='" + parentCaseId + '\'' +
                ", parentActivityId='" + parentActivityId + '\'' +
                ", workflowApplication='" + workflowApplication + '\'' +
                ", ownerGroupId=" + ownerGroupId +
                ", documentsState=" + documentsState +
                ", starterId=" + starterId +
                ", projectId='" + projectId + '\'' +
                ", bpdName='" + bpdName + '\'' +
                ", sboSyncEnabled='" + sboSyncEnabled + '\'' +
                ", canDeleteInstance='" + canDeleteInstance + '\'' +
                ", field1='" + field1 + '\'' +
                ", field2=" + field2 +
                ", field3='" + field3 + '\'' +
                ", field4='" + field4 + '\'' +
                ", field5='" + field5 + '\'' +
                '}';
    }
}
