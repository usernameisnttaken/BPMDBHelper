package ru.ertelecom.bpms.db.entity;


import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.util.Arrays;


@Entity
@Immutable
@Table(name = "LSW_BPD_INSTANCE_EXT_DATA")
public class LSWBPDInstanceExtData extends BPMDBEntity {
    @Id
    @Column(name = "BPD_EXTENDED_DATA_ID")
    private Long bpdExtendedDataId;

    @Column(name = "BPD_INSTANCE_ID")
    private Long bpdInstanceId;

    @Column(name = "DATA")
    @Lob
    private byte[] data;

    @Column(name = "TYPE")
    private Integer type;

    public Long getBpdExtendedDataId() {
        return bpdExtendedDataId;
    }

    public void setBpdExtendedDataId(Long bpdExtendedDataId) {
        this.bpdExtendedDataId = bpdExtendedDataId;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "LSWBPDInstanceExtData{" +
                "bpdExtendedDataId=" + bpdExtendedDataId +
                ", bpdInstanceId=" + bpdInstanceId +
                ", data=" + Arrays.toString(data) +
                ", type=" + type +
                '}';
    }
}
