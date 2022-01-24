package ru.ertelecom.bpms.db.entity;

import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;


@Entity
@Immutable
@Table(name = "LSW_INST_MSG_INCL")
public class LSWInstMsgIncl extends BPMDBEntity {
    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "CREATED_ON")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

    @Column(name = "BPD_INSTANCE_ID")
    private Long bpdInstanceId;

    @Column(name = "DURABLE")
    private String durable;

    @Column(name = "EVENT_ID")
    private String eventId;

    @Column(name = "SUB_EVENT_ID")
    private Long subEventId;

    @Column(name = "UCA_ID")
    private String ucaId;

    @Column(name = "CORRELATION_KEY")
    private Long correlationKey;

    @Column(name = "CORRELATION_TYPE")
    private Integer correlationType;

    @Column(name = "CORRELATION_STRING")
    private String correlationString;

    @Column(name = "CORRELATION_BLOB")
    @Lob
    private byte[] correlationBlob;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Long getBpdInstanceId() {
        return bpdInstanceId;
    }

    public void setBpdInstanceId(Long bpdInstanceId) {
        this.bpdInstanceId = bpdInstanceId;
    }

    public String getDurable() {
        return durable;
    }

    public void setDurable(String durable) {
        this.durable = durable;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public Long getSubEventId() {
        return subEventId;
    }

    public void setSubEventId(Long subEventId) {
        this.subEventId = subEventId;
    }

    public String getUcaId() {
        return ucaId;
    }

    public void setUcaId(String ucaId) {
        this.ucaId = ucaId;
    }

    public Long getCorrelationKey() {
        return correlationKey;
    }

    public void setCorrelationKey(Long correlationKey) {
        this.correlationKey = correlationKey;
    }

    public Integer getCorrelationType() {
        return correlationType;
    }

    public void setCorrelationType(Integer correlationType) {
        this.correlationType = correlationType;
    }

    public String getCorrelationString() {
        return correlationString;
    }

    public void setCorrelationString(String correlationString) {
        this.correlationString = correlationString;
    }

    public byte[] getCorrelationBlob() {
        return correlationBlob;
    }

    public void setCorrelationBlob(byte[] correlationBlob) {
        this.correlationBlob = correlationBlob;
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
        return "LSWInstMsgIncl{" +
                "id=" + id +
                ", createdOn=" + createdOn +
                ", bpdInstanceId=" + bpdInstanceId +
                ", durable='" + durable + '\'' +
                ", eventId='" + eventId + '\'' +
                ", subEventId=" + subEventId +
                ", ucaId='" + ucaId + '\'' +
                ", correlationKey=" + correlationKey +
                ", correlationType=" + correlationType +
                ", correlationString='" + correlationString + '\'' +
                ", correlationBlob=" + Arrays.toString(correlationBlob) +
                ", field1='" + field1 + '\'' +
                ", field2=" + field2 +
                ", field3='" + field3 + '\'' +
                ", field4='" + field4 + '\'' +
                ", field5='" + field5 + '\'' +
                '}';
    }
}
