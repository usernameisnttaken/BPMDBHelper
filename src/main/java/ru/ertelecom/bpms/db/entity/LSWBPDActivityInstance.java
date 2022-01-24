package ru.ertelecom.bpms.db.entity;

import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;


@Entity
@Immutable
@Table(name = "LSW_BPD_ACTIVITY_INSTANCE")
public class LSWBPDActivityInstance extends BPMDBEntity {
    @Id
    @Column(name = "INSTANCE_ID")
    private String instanceId;

    @Column(name = "BPD_FLOW_OBJECT_ID")
    private String bpdFlowObjectId;

    @Column(name = "PARENT_NODE_ID")
    private Long parentNodeId;

    @Column(name = "BPD_INSTANCE_ID")
    private Long bpdInstanceId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "EXECUTION_STATE")
    private Long executionState;

    @Column(name = "TASK_TYPE")
    private Long taskType;

    @Column(name = "TASK_ID")
    private Long taskId;

    @Column(name = "REQUIRED")
    private String required;

    @Column(name = "REPEATABLE")
    private String repeatable;

    @Column(name = "HIDDEN")
    private String hidden;

    @Column(name = "EXECUTION_TYPE")
    private Long executionType;

    @Column(name = "OPTION_TYPE")
    private Long optionType;

    @Column(name = "PRECONDITION_TYPE")
    private Long preconditionType;

    @Column(name = "OWNER_GROUP_ID")
    private Long ownerGroupId;

    @Column(name = "START_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;

    @Column(name = "END_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;

    @Column(name = "LAST_MODIFIED_DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Column(name = "ENABLING_DOCUMENT_ID")
    private String enablingDocumentId;

    @Column(name = "EVALUATED_NARRATIVES")
    @Lob
    private byte[] evaluatedNarratives;

    @Column(name = "ERRORS")
    @Lob
    private byte[] errors;

    @Column(name = "ENABLDOC_SERVER_NAME")
    private String enabldocServerName;

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

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public String getBpdFlowObjectId() {
        return bpdFlowObjectId;
    }

    public void setBpdFlowObjectId(String bpdFlowObjectId) {
        this.bpdFlowObjectId = bpdFlowObjectId;
    }

    public Long getParentNodeId() {
        return parentNodeId;
    }

    public void setParentNodeId(Long parentNodeId) {
        this.parentNodeId = parentNodeId;
    }

    public Long getBpdInstanceId() {
        return bpdInstanceId;
    }

    public void setBpdInstanceId(Long bpdInstanceId) {
        this.bpdInstanceId = bpdInstanceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getExecutionState() {
        return executionState;
    }

    public void setExecutionState(Long executionState) {
        this.executionState = executionState;
    }

    public Long getTaskType() {
        return taskType;
    }

    public void setTaskType(Long taskType) {
        this.taskType = taskType;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getRequired() {
        return required;
    }

    public void setRequired(String required) {
        this.required = required;
    }

    public String getRepeatable() {
        return repeatable;
    }

    public void setRepeatable(String repeatable) {
        this.repeatable = repeatable;
    }

    public String getHidden() {
        return hidden;
    }

    public void setHidden(String hidden) {
        this.hidden = hidden;
    }

    public Long getExecutionType() {
        return executionType;
    }

    public void setExecutionType(Long executionType) {
        this.executionType = executionType;
    }

    public Long getOptionType() {
        return optionType;
    }

    public void setOptionType(Long optionType) {
        this.optionType = optionType;
    }

    public Long getPreconditionType() {
        return preconditionType;
    }

    public void setPreconditionType(Long preconditionType) {
        this.preconditionType = preconditionType;
    }

    public Long getOwnerGroupId() {
        return ownerGroupId;
    }

    public void setOwnerGroupId(Long ownerGroupId) {
        this.ownerGroupId = ownerGroupId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getEnablingDocumentId() {
        return enablingDocumentId;
    }

    public void setEnablingDocumentId(String enablingDocumentId) {
        this.enablingDocumentId = enablingDocumentId;
    }

    public byte[] getEvaluatedNarratives() {
        return evaluatedNarratives;
    }

    public void setEvaluatedNarratives(byte[] evaluatedNarratives) {
        this.evaluatedNarratives = evaluatedNarratives;
    }

    public byte[] getErrors() {
        return errors;
    }

    public void setErrors(byte[] errors) {
        this.errors = errors;
    }

    public String getEnabldocServerName() {
        return enabldocServerName;
    }

    public void setEnabldocServerName(String enabldocServerName) {
        this.enabldocServerName = enabldocServerName;
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
        return "LSWBPDActivityInstance{" +
                "instanceId='" + instanceId + '\'' +
                ", bpdFlowObjectId='" + bpdFlowObjectId + '\'' +
                ", parentNodeId=" + parentNodeId +
                ", bpdInstanceId=" + bpdInstanceId +
                ", name='" + name + '\'' +
                ", executionState=" + executionState +
                ", taskType=" + taskType +
                ", taskId=" + taskId +
                ", required='" + required + '\'' +
                ", repeatable='" + repeatable + '\'' +
                ", hidden='" + hidden + '\'' +
                ", executionType=" + executionType +
                ", optionType=" + optionType +
                ", preconditionType=" + preconditionType +
                ", ownerGroupId=" + ownerGroupId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", lastModifiedDate=" + lastModifiedDate +
                ", enablingDocumentId='" + enablingDocumentId + '\'' +
                ", evaluatedNarratives=" + Arrays.toString(evaluatedNarratives) +
                ", errors=" + Arrays.toString(errors) +
                ", enabldocServerName='" + enabldocServerName + '\'' +
                ", field1='" + field1 + '\'' +
                ", field2=" + field2 +
                ", field3='" + field3 + '\'' +
                ", field4='" + field4 + '\'' +
                ", field5='" + field5 + '\'' +
                '}';
    }
}
