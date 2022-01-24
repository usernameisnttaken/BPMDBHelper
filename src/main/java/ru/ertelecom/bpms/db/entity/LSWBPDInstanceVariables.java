package ru.ertelecom.bpms.db.entity;


import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.util.Date;


@Entity
@Immutable
@Table(name = "LSW_BPD_INSTANCE_VARIABLES")
public class LSWBPDInstanceVariables extends BPMDBEntity {
    @Id
    @Column(name = "BPD_INST_VARS_ID")
    private Long bpdInstVarsId;

    @Column(name = "BPD_INSTANCE_ID")
    private Long bpdInstanceId;

    @Column(name = "VARIABLE_NAME")
    private String variableName;

    @Column(name = "ALIAS")
    private String alias;

    @Column(name = "BOOLEAN_VALUE")
    private String booleanValue;

    @Column(name = "STRING_VALUE")
    private String stringValue;

    @Column(name = "INT_VALUE")
    private Long intValue;

    @Column(name = "DEC_VALUE")
    private Double decValue;

    @Column(name = "DATE_VALUE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateValue;

    @Column(name = "VARIABLE_TYPE")
    private String variableType;

    public Long getBpdInstVarsId() {
        return bpdInstVarsId;
    }

    public void setBpdInstVarsId(Long bpdInstVarsId) {
        this.bpdInstVarsId = bpdInstVarsId;
    }

    public Long getBpdInstanceId() {
        return bpdInstanceId;
    }

    public void setBpdInstanceId(Long bpdInstanceId) {
        this.bpdInstanceId = bpdInstanceId;
    }

    public String getVariableName() {
        return variableName;
    }

    public void setVariableName(String variableName) {
        this.variableName = variableName;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getBooleanValue() {
        return booleanValue;
    }

    public void setBooleanValue(String booleanValue) {
        this.booleanValue = booleanValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    public Long getIntValue() {
        return intValue;
    }

    public void setIntValue(Long intValue) {
        this.intValue = intValue;
    }

    public Double getDecValue() {
        return decValue;
    }

    public void setDecValue(Double decValue) {
        this.decValue = decValue;
    }

    public Date getDateValue() {
        return dateValue;
    }

    public void setDateValue(Date dateValue) {
        this.dateValue = dateValue;
    }

    public String getVariableType() {
        return variableType;
    }

    public void setVariableType(String variableType) {
        this.variableType = variableType;
    }

    @Override
    public String toString() {
        return "LSWBPDInstanceVariables{" +
                "bpdInstVarsId=" + bpdInstVarsId +
                ", bpdInstanceId=" + bpdInstanceId +
                ", variableName='" + variableName + '\'' +
                ", alias='" + alias + '\'' +
                ", booleanValue='" + booleanValue + '\'' +
                ", stringValue='" + stringValue + '\'' +
                ", intValue=" + intValue +
                ", decValue=" + decValue +
                ", dateValue=" + dateValue +
                ", variableType='" + variableType + '\'' +
                '}';
    }
}
