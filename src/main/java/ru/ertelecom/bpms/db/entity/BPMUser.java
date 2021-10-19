package ru.ertelecom.bpms.db.entity;


import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Immutable
@Table(name = "LSW_USR_XREF")
public class BPMUser {
    // Id пользователя
    @Id
    @Column(name = "USER_ID")
    private Long userId;
    // Имя пользователя
    @Column(name = "USER_NAME")
    private String userName;
    // ФИО
    @Column(name = "FULL_NAME")
    private String fullName;

    @Override
    public String toString() {
        return "BPMUser{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }

    public BPMUser() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
