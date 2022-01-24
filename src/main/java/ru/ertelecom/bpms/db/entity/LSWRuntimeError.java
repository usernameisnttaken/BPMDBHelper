package ru.ertelecom.bpms.db.entity;

import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;


@Entity
@Immutable
@Table(name = "LSW_RUNTIME_ERROR")
public class LSWRuntimeError extends BPMDBEntity {
    @Id
    @Column(name = "ERROR_ID")
    private Long errorId;

    @Column(name = "TIP")
    private String tip;

    @Column(name = "SNAPSHOT_ID")
    private String snapshotId;

    @Column(name = "ERROR_MESSAGE")
    private String errorMessage;

    @Column(name = "LOGGED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date logged;

    @Column(name = "BPD_INSTANCE_ID")
    private Long bpdInstanceId;

    @Column(name = "TASK_ID")
    private Long taskId;

    @Column(name = "SOURCE_REF")
    private Long sourceRef;

    @Column(name = "SOURCE_GUID")
    private String sourceGuid;

    @Column(name = "JAVA_TRACE")
    @Lob
    private byte[] javaTrace;

    @Column(name = "JS_TRACE")
    @Lob
    private byte[] jsTrace;

    @Column(name = "TW_TRACE")
    @Lob
    private byte[] twTrace;

    @Column(name = "ERROR_CODE")
    private String errorCode;

    @Column(name = "ERROR_DATA")
    @Lob
    private byte[] errorData;

    @Column(name = "FAULT_STYLE")
    private Integer faultStyle;

    public Long getErrorId() {
        return errorId;
    }

    public void setErrorId(Long errorId) {
        this.errorId = errorId;
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

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Date getLogged() {
        return logged;
    }

    public void setLogged(Date logged) {
        this.logged = logged;
    }

    public Long getBpdInstanceId() {
        return bpdInstanceId;
    }

    public void setBpdInstanceId(Long bpdInstanceId) {
        this.bpdInstanceId = bpdInstanceId;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Long getSourceRef() {
        return sourceRef;
    }

    public void setSourceRef(Long sourceRef) {
        this.sourceRef = sourceRef;
    }

    public byte[] getJavaTrace() {
        return javaTrace;
    }

    public void setJavaTrace(byte[] javaTrace) {
        this.javaTrace = javaTrace;
    }

    public byte[] getJsTrace() {
        return jsTrace;
    }

    public void setJsTrace(byte[] jsTrace) {
        this.jsTrace = jsTrace;
    }

    public byte[] getTwTrace() {
        return twTrace;
    }

    public void setTwTrace(byte[] twTrace) {
        this.twTrace = twTrace;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public byte[] getErrorData() {
        return errorData;
    }

    public void setErrorData(byte[] errorData) {
        this.errorData = errorData;
    }

    public Integer getFaultStyle() {
        return faultStyle;
    }

    public void setFaultStyle(Integer faultStyle) {
        this.faultStyle = faultStyle;
    }

    @Override
    public String toString() {
        return "LSWRuntimeError{" +
                "errorId=" + errorId +
                ", tip='" + tip + '\'' +
                ", snapshotId='" + snapshotId + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                ", logged=" + logged +
                ", bpdInstanceId=" + bpdInstanceId +
                ", taskId=" + taskId +
                ", sourceRef=" + sourceRef +
                ", sourceGuid='" + sourceGuid + '\'' +
                ", javaTrace=" + Arrays.toString(javaTrace) +
                ", jsTrace=" + Arrays.toString(jsTrace) +
                ", twTrace=" + Arrays.toString(twTrace) +
                ", errorCode='" + errorCode + '\'' +
                ", errorData=" + Arrays.toString(errorData) +
                ", faultStyle=" + faultStyle +
                '}';
    }

    public String getSourceGuid() {
        return sourceGuid;
    }

    public void setSourceGuid(String sourceGuid) {
        this.sourceGuid = sourceGuid;
    }

}
