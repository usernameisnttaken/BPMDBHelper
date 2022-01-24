package ru.ertelecom.bpms.db.entity;

import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.util.Arrays;


@Entity
@Immutable
@Table(name = "LSW_BPD_NOTIFICATION")
public class LSWBPDNotification extends BPMDBEntity {
    @Id
    @Column(name = "BPD_NOTIFICATION_ID")
    private Long bpdNotificationId;

    @Column(name = "BPD_INSTANCE_ID")
    private Long bpdInstanceId;

    @Column(name = "STATUS")
    private Long status;

    @Column(name = "ERROR")
    private String error;

    @Column(name = "ERROR_STACK_TRACE")
    private String errorStackTrace;

    @Column(name = "DATA")
    @Lob
    private byte[] data;

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

    public Long getBpdNotificationId() {
        return bpdNotificationId;
    }

    public void setBpdNotificationId(Long bpdNotificationId) {
        this.bpdNotificationId = bpdNotificationId;
    }

    public Long getBpdInstanceId() {
        return bpdInstanceId;
    }

    public void setBpdInstanceId(Long bpdInstanceId) {
        this.bpdInstanceId = bpdInstanceId;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
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

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
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
        return "LSWBPDNotification{" +
                "bpdNotificationId=" + bpdNotificationId +
                ", bpdInstanceId=" + bpdInstanceId +
                ", status=" + status +
                ", error='" + error + '\'' +
                ", errorStackTrace='" + errorStackTrace + '\'' +
                ", data=" + Arrays.toString(data) +
                ", field1='" + field1 + '\'' +
                ", field2=" + field2 +
                ", field3='" + field3 + '\'' +
                ", field4='" + field4 + '\'' +
                ", field5='" + field5 + '\'' +
                '}';
    }
}
