package ru.ertelecom.bpms.db.entity;

import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


// TODO: в bpmdb используется композитный ПК - необходимо реализовать
@Entity
@Immutable
@Table(name = "LSW_USR_GRP_MEM_XREF")
public class LSWUsrGrpMemXref {
    @Column(name = "USER_ID")
    private Long userId;

    @Id
    @Column(name = "GROUP_ID")
    private Long groupId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return "LSWUsrGrpMemXref{" +
                "userId=" + userId +
                ", groupId=" + groupId +
                '}';
    }
}
