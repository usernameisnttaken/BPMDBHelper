package ru.ertelecom.bpms.db.entity;


import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Immutable
@Table(name = "LSW_BPD_INSTANCE_CORRELATION")
public class LSWBPDInstanceCorrelation extends BPMDBEntity {
    @Id
    @Column(name = "CORRELATION_PK")
    private Long correlationPK;

    @Column(name = "BPD_ID")
    private String bpdId;

    @Column(name = "BPD_INSTANCE_ID")
    private Long bpdInstanceId;

    @Column(name = "CORRELATION_NAME")
    private String correlationName;

    @Column(name = "CORRELATION_VALUE")
    private String correlationValue;

    @Column(name = "HASH_CODE")
    private String hashCode;

    @Column(name = "CORRELATION_TYPE")
    private Integer correlationType;

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

    public Long getCorrelationPK() {
        return correlationPK;
    }

    public void setCorrelationPK(Long correlationPK) {
        this.correlationPK = correlationPK;
    }

    public String getBpdId() {
        return bpdId;
    }

    public void setBpdId(String bpdId) {
        this.bpdId = bpdId;
    }

    public Long getBpdInstanceId() {
        return bpdInstanceId;
    }

    public void setBpdInstanceId(Long bpdInstanceId) {
        this.bpdInstanceId = bpdInstanceId;
    }

    public String getCorrelationName() {
        return correlationName;
    }

    public void setCorrelationName(String correlationName) {
        this.correlationName = correlationName;
    }

    public String getCorrelationValue() {
        return correlationValue;
    }

    public void setCorrelationValue(String correlationValue) {
        this.correlationValue = correlationValue;
    }

    public String getHashCode() {
        return hashCode;
    }

    public void setHashCode(String hashCode) {
        this.hashCode = hashCode;
    }

    public Integer getCorrelationType() {
        return correlationType;
    }

    public void setCorrelationType(Integer correlationType) {
        this.correlationType = correlationType;
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
        return "LSWBPDInstanceCorrelation{" +
                "correlationPK=" + correlationPK +
                ", bpdId='" + bpdId + '\'' +
                ", bpdInstanceId=" + bpdInstanceId +
                ", correlationName='" + correlationName + '\'' +
                ", correlationValue='" + correlationValue + '\'' +
                ", hashCode='" + hashCode + '\'' +
                ", correlationType=" + correlationType +
                ", field1='" + field1 + '\'' +
                ", field2=" + field2 +
                ", field3='" + field3 + '\'' +
                ", field4='" + field4 + '\'' +
                ", field5='" + field5 + '\'' +
                '}';
    }
}
