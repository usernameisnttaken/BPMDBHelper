package ru.ertelecom.bpms.db.entity;

import org.hibernate.annotations.Immutable;

import javax.persistence.*;

@Entity
@Immutable
@Table(name = "LSW_BPD_INSTANCE_DATA")
public class BPMProcessInstanceData {
    @Id
    @Column(name = "BPD_INSTANCE_ID")
    private Long bpdInstanceId;
    @Lob
    @Column(name = "DATA")
    private byte[] data;

    public BPMProcessInstanceData() {
    }

    @Override
    public String toString() {
        return "BPMProcessInstanceData{" +
                "bpdInstanceId=" + bpdInstanceId +
                ", data=" + data +
                '}';
    }

    public Long getBpdInstanceId() {
        return bpdInstanceId;
    }

    public void setBpdInstanceId(Long bpdInstanceId) {
        this.bpdInstanceId = bpdInstanceId;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
