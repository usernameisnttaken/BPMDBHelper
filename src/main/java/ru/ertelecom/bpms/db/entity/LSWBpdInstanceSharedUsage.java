package ru.ertelecom.bpms.db.entity;


import org.hibernate.annotations.Immutable;

import javax.persistence.*;


// TODO: в bpmdb используется композитный ПК - нужно реализовать
@Entity
@Immutable
@Table(name = "LSW_BPD_INSTANCE_SHARED_USAGE")
public class LSWBpdInstanceSharedUsage extends BPMDBEntity {
    @Id
    @Column(name = "BPD_INSTANCE_ID")
    private Long bpdInstanceId;

    @Column(name = "SHARED_OBJECT_ID")
    private String sharedObjectId;

    @Column(name = "SHARED_OBJECT_VERSION")
    private Long sharedObjectVersion;

    public Long getBpdInstanceId() {
        return bpdInstanceId;
    }

    public void setBpdInstanceId(Long bpdInstanceId) {
        this.bpdInstanceId = bpdInstanceId;
    }

    public String getSharedObjectId() {
        return sharedObjectId;
    }

    public void setSharedObjectId(String sharedObjectId) {
        this.sharedObjectId = sharedObjectId;
    }

    public Long getSharedObjectVersion() {
        return sharedObjectVersion;
    }

    public void setSharedObjectVersion(Long sharedObjectVersion) {
        this.sharedObjectVersion = sharedObjectVersion;
    }

    @Override
    public String toString() {
        return "LSWBpdInstanceSharedUsage{" +
                "bpdInstanceId=" + bpdInstanceId +
                ", sharedObjectId='" + sharedObjectId + '\'' +
                ", sharedObjectVersion=" + sharedObjectVersion +
                '}';
    }
}
