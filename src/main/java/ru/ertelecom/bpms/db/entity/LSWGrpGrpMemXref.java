package ru.ertelecom.bpms.db.entity;

import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


// TODO: в bpmdb исползуется композитный ПК - необходимо реализовать
@Entity
@Immutable
@Table(name = "LSW_GRP_GRP_MEM_XREF")
public class LSWGrpGrpMemXref {
    @Id
    @Column(name = "GROUP_ID")
    private Long groupId;

    @Column(name = "CONTAINER_GROUP_ID")
    private Long containerGroupId;

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

    @Override
    public String toString() {
        return "LSWGrpGrpMemXref{" +
                "groupId=" + groupId +
                ", containerGroupId=" + containerGroupId +
                '}';
    }
}
