package ru.ertelecom.bpms.db.entity;


import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Immutable
@Table(name = "LSW_TASK_EXECUTION_CONTEXT")
public class LSWTaskExecutionContext extends BPMDBEntity {
    @Id
    @Column(name = "TASK_EXECUTION_CONTEXT_ID")
    private Long taskExecutionContextId;

    @Column(name = "TASK_ID")
    private Long taskId;

    @Lob
    @Column(name = "EXECUTION_CONTEXT")
    private byte[] executionContext;

    @Override
    public String toString() {
        return "LSWTaskExecutionContext{" +
                "taskExecutionContextId=" + taskExecutionContextId +
                ", taskId=" + taskId +
                ", executionContext=" + Arrays.toString(executionContext) +
                '}';
    }

    public Long getTaskExecutionContextId() {
        return taskExecutionContextId;
    }

    public void setTaskExecutionContextId(Long taskExecutionContextId) {
        this.taskExecutionContextId = taskExecutionContextId;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public byte[] getExecutionContext() {
        return executionContext;
    }

    public void setExecutionContext(byte[] executionContext) {
        this.executionContext = executionContext;
    }
}
