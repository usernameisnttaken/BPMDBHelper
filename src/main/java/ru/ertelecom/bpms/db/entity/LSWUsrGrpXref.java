package ru.ertelecom.bpms.db.entity;


import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Immutable
@Table(name = "LSW_USR_GRP_XREF")
public class LSWUsrGrpXref {
    @Id
    @Column(name = "GROUP_ID")
    private Long groupId;

    @Column(name = "GROUP_NAME")
    private String groupName;

    @Column(name = "DISPLAY_NAME")
    private String displayName;

    @Column(name = "PARENT_GROUP_ID")
    private Long parentGroupId;

    @Column(name = "GROUP_TYPE")
    private Integer typeId;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "GROUP_STATE")
    private Integer stateId;

    @Column(name = "PARTICIPANT_ID")
    private String participantId;

    @Override
    public String toString() {
        return "LSWUsrGrpXref{" +
                "groupId=" + groupId +
                ", groupName='" + groupName + '\'' +
                ", displayName='" + displayName + '\'' +
                ", parentGroupId=" + parentGroupId +
                ", typeId=" + typeId +
                ", description='" + description + '\'' +
                ", stateId=" + stateId +
                ", participantId='" + participantId + '\'' +
                '}';
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Long getParentGroupId() {
        return parentGroupId;
    }

    public void setParentGroupId(Long parentGroupId) {
        this.parentGroupId = parentGroupId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public String getParticipantId() {
        return participantId;
    }

    public void setParticipantId(String participantId) {
        this.participantId = participantId;
    }
}
