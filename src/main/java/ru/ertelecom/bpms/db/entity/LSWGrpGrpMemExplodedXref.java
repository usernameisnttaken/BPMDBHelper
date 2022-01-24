package ru.ertelecom.bpms.db.entity;


import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Immutable
@Table(name = "LSW_GRP_GRP_MEM_EXPLODED_XREF")
public class LSWGrpGrpMemExplodedXref {
    @Id
    @Column(name = "GROUP_ID")
    private Long groupId;

    @Column(name = "CONTAINER_GROUP_ID")
    private Long containerGroupId;

    @Column(name = "MEM_PATH")
    private String memPath;

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getContainerGroupId() {
        return containerGroupId;
    }

    public void setContainerGroupId(Long containerGroupId) {
        this.containerGroupId = containerGroupId;
    }

    public String getMemPath() {
        return memPath;
    }

    public void setMemPath(String memPath) {
        this.memPath = memPath;
    }

    @Override
    public String toString() {
        return "LSWGrpGrpMemExplodedXrefDAO{" +
                "groupId=" + groupId +
                ", containerGroupId=" + containerGroupId +
                ", memPath='" + memPath + '\'' +
                '}';
    }
}
