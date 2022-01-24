package ru.ertelecom.bpms.db.entity;


import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Immutable
@Table(name = "LSW_BPD_INSTANCE_DOC_PROPS")
public class LSWBPDInstanceDocProps extends BPMDBEntity {
    @Id
    @Column(name = "DOC_ID")
    private Long docId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "VALUE")
    private String value;

    public Long getDocId() {
        return docId;
    }

    public void setDocId(Long docId) {
        this.docId = docId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "LSWBPDInstanceDocProps{" +
                "docId=" + docId +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
