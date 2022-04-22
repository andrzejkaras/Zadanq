package org.actionLog;

import org.commons.*;

import java.util.*;

final class InMemoryLog implements ActionLog, EventStatsProvider {
    private final List<LogEntry> actionLog;
    private final Map<String, Integer> errorOperationStats;
    private final Map<String, Integer> addOperationStats;
    private final Map<String, Integer> subOperationStats;

    InMemoryLog() {
        this.actionLog = new ArrayList<>();
        this.errorOperationStats = new HashMap<>();
        this.addOperationStats = new HashMap<>();
        this.subOperationStats = new HashMap<>();
    }

    @Override
    public void append(LogEntry entry) {
        actionLog.add(entry);
        error(entry);
        addOp(entry);
        subOp(entry);
    }
    @Override
    public Set<String> getContainerNameWithTheMostErrors() {
        return findMaxFrom(errorOperationStats);
    }

    @Override
    public Set<String> getContainerWithMaxOpType(Operation operation) {
        if (Operation.ADD.equals(operation)) {
            return findMaxFrom(addOperationStats);
        } else if (Operation.SUB.equals(operation)) {
            return findMaxFrom(subOperationStats);
        }

        throw new IllegalArgumentException("Invalid operation type!");
    }

    @Override
    public double findActualCapacity(String name) {
        var temp = actionLog.stream()
                .filter(entry -> entry.getContainerName().equals(name))
                .sorted(Comparator.comparing(LogEntry::getCreated))
                .toList();

        double capacity = 0;
        for (var entry: temp) {
            if (entry.isSuccess() && entry.getOperation().equals(Operation.ADD)) {
                capacity += entry.getDelta();
            } else if (entry.isSuccess() && entry.getOperation().equals(Operation.SUB)) {
                capacity -= entry.getDelta();
            }
        }

        return capacity;
    }

    private Set<String> findMaxFrom(Map<String, Integer> map) {
        int max = -1;
        Set<String> names = new HashSet<>();

        for (var temp : map.entrySet()) {
            if (temp.getValue() > max) {
                max = temp.getValue();
            }
        }

        if (max <= 0) {
            return names;
        }

        for (var temp : map.entrySet()) {
            if (temp.getValue() == max) {
                names.add(temp.getKey());
            }
        }

        return names;
    }

    private void error(LogEntry entry) {
        if (entry.isSuccess()) {
            return;
        }

        calculate(errorOperationStats, entry.getContainerName());
    }

    private void addOp(LogEntry entry) {
        if (!entry.getOperation().equals(Operation.ADD)) {
            return;
        }

        calculate(addOperationStats, entry.getContainerName());
    }

    private void subOp(LogEntry entry) {
        if (!entry.getOperation().equals(Operation.SUB)) {
            return;
        }

        calculate(subOperationStats, entry.getContainerName());
    }

    private void calculate(Map<String, Integer> map, String container) {
        if (!map.containsKey(container)) {
            map.put(container, 1);
        } else {
            map.merge(container, 1, Integer::sum);
        }
    }
}
