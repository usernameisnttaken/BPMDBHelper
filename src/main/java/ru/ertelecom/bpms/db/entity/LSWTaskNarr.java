package ru.ertelecom.bpms.db.entity;

import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.util.Arrays;


@Entity
@Immutable
@Table(name = "LSW_TASK_NARR")
public class LSWTaskNarr extends BPMDBEntity {
    @Id
    @Column(name = "TASK_NARR_ID")
    private Long taskNarrId;

    @Column(name = "TASK_ID")
    private Long taskId;

    @Column(name = "SEQ")
    private Long seq;

    @Lob
    @Column(name = "NARRATIVE")
    private byte[] narrative;

    @Lob
    @Column(name = "NARRATIVE_RAW")
    private byte[] narrativeRaw;

    @Lob
    @Column(name = "I18N_NARRATIVES")
    private byte[] i18nNarratives;

    @Column(name = "FIELD1")
    private String field1;

    @Column(name = "FIELD2")
    private Long field2;

    @Column(name = "FIELD3")
    private String field3;

    @Column(name = "FIELD4")
    private String field4;

    @Column(name = "FIELD5")
    private String field5;

    @Override
    public String toString() {
        return "LSWTaskNarr{" +
                "taskNarrId=" + taskNarrId +
                ", taskId=" + taskId +
                ", seq=" + seq +
                ", narrative=" + Arrays.toString(narrative) +
                ", narrativeRaw=" + Arrays.toString(narrativeRaw) +
                ", i18nNarratives=" + Arrays.toString(i18nNarratives) +
                ", field1='" + field1 + '\'' +
                ", field2=" + field2 +
                ", field3='" + field3 + '\'' +
                ", field4='" + field4 + '\'' +
                ", field5=" + field5 +
                '}';
    }

    public Long getTaskNarrId() {
        return taskNarrId;
    }

    public void setTaskNarrId(Long taskNarrId) {
        this.taskNarrId = taskNarrId;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Long getSeq() {
        return seq;
    }

    public void setSeq(Long seq) {
        this.seq = seq;
    }

    public byte[] getNarrative() {
        return narrative;
    }

    public void setNarrative(byte[] narrative) {
        this.narrative = narrative;
    }

    public byte[] getNarrativeRaw() {
        return narrativeRaw;
    }

    public void setNarrativeRaw(byte[] narrativeRaw) {
        this.narrativeRaw = narrativeRaw;
    }

    public byte[] getI18nNarratives() {
        return i18nNarratives;
    }

    public void setI18nNarratives(byte[] i18nNarratives) {
        this.i18nNarratives = i18nNarratives;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public Long getField2() {
        return field2;
    }

    public void setField2(Long field2) {
        this.field2 = field2;
    }

    public String getField3() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3 = field3;
    }

    public String getField4() {
        return field4;
    }

    public void setField4(String field4) {
        this.field4 = field4;
    }

    public String getField5() {
        return field5;
    }

    public void setField5(String field5) {
        this.field5 = field5;
    }
}
