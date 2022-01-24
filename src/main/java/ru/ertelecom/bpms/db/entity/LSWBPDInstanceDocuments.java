package ru.ertelecom.bpms.db.entity;


import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;


@Entity
@Immutable
@Table(name = "LSW_BPD_INSTANCE_DOCUMENTS")
public class LSWBPDInstanceDocuments extends BPMDBEntity {
    @Id
    @Column(name = "DOC_ID")
    private Long docId;

    @Column(name = "BPD_INSTANCE_ID")
    private Long bpdInstanceId;

    @Column(name = "PARENT_DOC_ID")
    private Long parentDocId;

    @Column(name = "DOC_NAME")
    private String docName;

    @Column(name = "FILENAME")
    private String filename;

    @Column(name = "FILETYPE")
    private Integer filetype;

    @Column(name = "AUTHOR_ID")
    private Long authorId;

    @Column(name = "AUTHORED_DTG")
    @Temporal(TemporalType.TIMESTAMP)
    private Date authoredDtg;

    @Column(name = "VERSION")
    private Integer version;

    @Column(name = "CONTENT_TYPE")
    private String contentType;

    @Column(name = "DOCUMENT")
    @Lob
    private byte[] document;

    @Column(name = "HIDE_IN_PORTAL")
    private String hideInPortal;

    @Column(name = "MIGRATION_STATE")
    private Integer migrationState;

    @Column(name = "MIGRATION_ERROR")
    private String migrationError;

    public Long getDocId() {
        return docId;
    }

    public void setDocId(Long docId) {
        this.docId = docId;
    }

    public Long getBpdInstanceId() {
        return bpdInstanceId;
    }

    public void setBpdInstanceId(Long bpdInstanceId) {
        this.bpdInstanceId = bpdInstanceId;
    }

    public Long getParentDocId() {
        return parentDocId;
    }

    public void setParentDocId(Long parentDocId) {
        this.parentDocId = parentDocId;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Integer getFiletype() {
        return filetype;
    }

    public void setFiletype(Integer filetype) {
        this.filetype = filetype;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Date getAuthoredDtg() {
        return authoredDtg;
    }

    public void setAuthoredDtg(Date authoredDtg) {
        this.authoredDtg = authoredDtg;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public byte[] getDocument() {
        return document;
    }

    public void setDocument(byte[] document) {
        this.document = document;
    }

    public String getHideInPortal() {
        return hideInPortal;
    }

    public void setHideInPortal(String hideInPortal) {
        this.hideInPortal = hideInPortal;
    }

    public Integer getMigrationState() {
        return migrationState;
    }

    public void setMigrationState(Integer migrationState) {
        this.migrationState = migrationState;
    }

    public String getMigrationError() {
        return migrationError;
    }

    public void setMigrationError(String migrationError) {
        this.migrationError = migrationError;
    }

    @Override
    public String toString() {
        return "LSWBPDInstanceDocuments{" +
                "docId=" + docId +
                ", bpdInstanceId=" + bpdInstanceId +
                ", parentDocId=" + parentDocId +
                ", docName='" + docName + '\'' +
                ", filename='" + filename + '\'' +
                ", filetype=" + filetype +
                ", authorId=" + authorId +
                ", authoredDtg=" + authoredDtg +
                ", version=" + version +
                ", contentType='" + contentType + '\'' +
                ", document=" + Arrays.toString(document) +
                ", hideInPortal='" + hideInPortal + '\'' +
                ", migrationState=" + migrationState +
                ", migrationError='" + migrationError + '\'' +
                '}';
    }
}
