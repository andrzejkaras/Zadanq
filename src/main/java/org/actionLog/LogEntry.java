package org.actionLog;

import org.commons.*;

import java.time.*;

public class LogEntry {
    private Instant created;
    private Operation operation;
    private String containerName;
    private double delta;
    private boolean success;

    public LogEntry() {}

    public LogEntry(Operation operation, String containerName, double delta, boolean successful, Instant created) {
        this.created = created;
        this.operation = operation;
        this.containerName = containerName;
        this.delta = delta;
        this.success = successful;
    }

    public LogEntry(Operation operation, String containerName, double delta, boolean successful) {
        this.created = Instant.now();
        this.operation = operation;
        this.containerName = containerName;
        this.delta = delta;
        this.success = successful;
    }

    @Override
    public String toString() {
        return "LogEntry{" +
                "created=" + created +
                ", operation=" + operation +
                ", containerName='" + containerName + '\'' +
                ", delta=" + delta +
                ", success=" + success +
                '}';
    }

    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
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
