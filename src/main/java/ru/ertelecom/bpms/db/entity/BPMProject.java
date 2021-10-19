package ru.ertelecom.bpms.db.entity;


import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Immutable
@Table(name = "LSW_PROJECT")
public class BPMProject {
    // Id проекта
    @Id
    @Column(name = "PROJECT_ID")
    private String projectId;
    // Наименование проекта
    @Column(name = "NAME")
    private String name;
    // Акроним
    @Column(name = "SHORT_NAME")
    private String acronym;

    public BPMProject() {
    }

    @Override
    public String toString() {
        return "BPMProject{" +
                "projectId='" + projectId + '\'' +
                ", name='" + name + '\'' +
                ", acronym='" + acronym + '\'' +
                '}';
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }
}
