package org.actionLog;

import java.time.*;

public class LogEntry {
    private Instant created;
    private String operationName;
    private String containerName;
    private double delta;
    private boolean success;

    public LogEntry() {}

    public LogEntry(Instant created, String operationName, String containerName, double delta) {
        this.created = created;
        this.operationName = operationName;
        this.containerName = containerName;
        this.delta = delta;
        this.success = true;
    }

    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public String getContainerName() {
        return containerName;
    }

    public void setContainerName(String containerName) {
        this.containerName = containerName;
    }

    public double getDelta() {
        return delta;
    }

    public void setDelta(double delta) {
        this.delta = delta;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
