package ru.ertelecom.bpms.db.entity;

import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.util.Date;

@Entity
@Immutable
@Table(name = "BPM_ECM_OBJECT")
public class BPMECMObject extends BPMDBEntity {
    @Id
    @Column(name = "ECM_OBJECT_ID")
    private String ecmObjectId;

    @Column(name = "BPD_INSTANCE_ID")
    private Long bpdInstanceId;

    @Column(name = "OBJECT_TYPE")
    private Integer objectType;

    @Column(name = "PARENT_ID")
    private String parentId;

    @Column(name = "AUTHORED_OBJECT_ID")
    private String authoredObjectId;

    @Column(name = "ALLOW_LOCAL_DOC")
    private Integer allowLocalDoc;

    @Column(name = "ALLOW_FOLDER_REF")
    private Integer allowFolderRef;

    @Column(name = "ALLOW_DOC_REF")
    private Integer allowDocRef;

    @Column(name = "ALLOW_SUB_FOLDER")
    private Integer allowSubFolder;

    @Column(name = "OBJECT_NAME")
    private String objectName;

    @Column(name = "SERVER_NAME")
    private String serverName;

    @Column(name = "EVENT_SOURCE_ID")
    private String eventSourceId;

    @Column(name = "OBJECT_ID")
    private String objectId;

    @Column(name = "VERSION_SERIES_ID")
    private String versionSeriesId;

    @Column(name = "OBJECT_TYPE_ID")
    private String objectTypeId;

    @Column(name = "BPMDOC_ID")
    private Long bpmdocId;

    @Column(name = "BPMDOC_PARENT_ID")
    private Long bpmdocParentId;

    @Column(name = "CREATED_BY_USER_ID")
    private Long createdByUserId;

    @Column(name = "CREATED_ON")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

    @Column(name = "LAST_MODIFIED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModified;

    @Column(name = "LAST_MODIFIED_BY_USER_ID")
    private Long lastModifiedByUserId;

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

    public String getEcmObjectId() {
        return ecmObjectId;
    }

    public void setEcmObjectId(String ecmObjectId) {
        this.ecmObjectId = ecmObjectId;
    }

    public Long getBpdInstanceId() {
        return bpdInstanceId;
    }

    public void setBpdInstanceId(Long bpdInstanceId) {
        this.bpdInstanceId = bpdInstanceId;
    }

    public Integer getObjectType() {
        return objectType;
    }

    public void setObjectType(Integer objectType) {
        this.objectType = objectType;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getAuthoredObjectId() {
        return authoredObjectId;
    }

    public void setAuthoredObjectId(String authoredObjectId) {
        this.authoredObjectId = authoredObjectId;
    }

    public Integer getAllowLocalDoc() {
        return allowLocalDoc;
    }

    public void setAllowLocalDoc(Integer allowLocalDoc) {
        this.allowLocalDoc = allowLocalDoc;
    }

    public Integer getAllowFolderRef() {
        return allowFolderRef;
    }

    public void setAllowFolderRef(Integer allowFolderRef) {
        this.allowFolderRef = allowFolderRef;
    }

    public Integer getAllowDocRef() {
        return allowDocRef;
    }

    public void setAllowDocRef(Integer allowDocRef) {
        this.allowDocRef = allowDocRef;
    }

    public Integer getAllowSubFolder() {
        return allowSubFolder;
    }

    public void setAllowSubFolder(Integer allowSubFolder) {
        this.allowSubFolder = allowSubFolder;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getEventSourceId() {
        return eventSourceId;
    }

    public void setEventSourceId(String eventSourceId) {
        this.eventSourceId = eventSourceId;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getVersionSeriesId() {
        return versionSeriesId;
    }

    public void setVersionSeriesId(String versionSeriesId) {
        this.versionSeriesId = versionSeriesId;
    }

    public String getObjectTypeId() {
        return objectTypeId;
    }

    public void setObjectTypeId(String objectTypeId) {
        this.objectTypeId = objectTypeId;
    }

    public Long getBpmdocId() {
        return bpmdocId;
    }

    public void setBpmdocId(Long bpmdocId) {
        this.bpmdocId = bpmdocId;
    }

    public Long getBpmdocParentId() {
        return bpmdocParentId;
    }

    public void setBpmdocParentId(Long bpmdocParentId) {
        this.bpmdocParentId = bpmdocParentId;
    }

    public Long getCreatedByUserId() {
        return createdByUserId;
    }

    public void setCreatedByUserId(Long createdByUserId) {
        this.createdByUserId = createdByUserId;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public Long getLastModifiedByUserId() {
        return lastModifiedByUserId;
    }

    public void setLastModifiedByUserId(Long lastModifiedByUserId) {
        this.lastModifiedByUserId = lastModifiedByUserId;
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
        return "BPMECMObject{" +
                "ecmObjectId='" + ecmObjectId + '\'' +
                ", bpdInstanceId=" + bpdInstanceId +
                ", objectType=" + objectType +
                ", parentId='" + parentId + '\'' +
                ", authoredObjectId='" + authoredObjectId + '\'' +
                ", allowLocalDoc=" + allowLocalDoc +
                ", allowFolderRef=" + allowFolderRef +
                ", allowDocRef=" + allowDocRef +
                ", allowSubFolder=" + allowSubFolder +
                ", objectName='" + objectName + '\'' +
                ", serverName='" + serverName + '\'' +
                ", eventSourceId='" + eventSourceId + '\'' +
                ", objectId='" + objectId + '\'' +
                ", versionSeriesId='" + versionSeriesId + '\'' +
                ", objectTypeId='" + objectTypeId + '\'' +
                ", bpmdocId=" + bpmdocId +
                ", bpmdocParentId=" + bpmdocParentId +
                ", createdByUserId=" + createdByUserId +
                ", createdOn=" + createdOn +
                ", lastModified=" + lastModified +
                ", lastModifiedByUserId=" + lastModifiedByUserId +
                ", field1='" + field1 + '\'' +
                ", field2=" + field2 +
                ", field3='" + field3 + '\'' +
                ", field4='" + field4 + '\'' +
                ", field5='" + field5 + '\'' +
                '}';
    }
}
