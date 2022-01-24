package ru.ertelecom.bpms.db.entity;

import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.util.Date;


@Entity
@Immutable
@Table(name = "LSW_INST_MSG_EXCL")
public class LSWInstMsgExcl extends BPMDBEntity {
    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "CREATED_ON")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

    @Column(name = "BPD_INSTANCE_ID")
    private Long bpdInstanceId;

    @Column(name = "EVENT_ID")
    private String eventId;

    @Column(name = "SUB_EVENT_ID")
    private Long subEventId;

    @Column(name = "MSG_ID")
    private Long msgId;

    @Column(name = "WAIT_ID")
    private Long waitId;

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

    public Long getMsgId() {
        return msgId;
    }

    public void setMsgId(Long msgId) {
        this.msgId = msgId;
    }

    public Long getWaitId() {
        return waitId;
    }

    public void setWaitId(Long waitId) {
        this.waitId = waitId;
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
        return "LSWInstMsgExcl{" +
                "id=" + id +
                ", createdOn=" + createdOn +
                ", bpdInstanceId=" + bpdInstanceId +
                ", eventId='" + eventId + '\'' +
                ", subEventId=" + subEventId +
                ", msgId=" + msgId +
                ", waitId=" + waitId +
                ", field1='" + field1 + '\'' +
                ", field2=" + field2 +
                ", field3='" + field3 + '\'' +
                ", field4='" + field4 + '\'' +
                ", field5='" + field5 + '\'' +
                '}';
    }
}
