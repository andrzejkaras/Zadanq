package org.actionLog;

import java.util.*;

public class ApplicationLog {
    private final List<LogEntry> actionLog = new ArrayList<>();

    private final Map<String, Integer> errorOperationStats = new HashMap<>();
    private final Map<String, Integer> addOperationStats = new HashMap<>();
    private final Map<String, Integer> subOperationStats = new HashMap<>();

    public void append(LogEntry entry) {
        actionLog.add(entry);
        error(entry);

        addOp(entry);
        subOp(entry);
    }

    public Set<String> getContainerNameWithTheMostErrors() {
        return findMaxFrom(errorOperationStats);
    }

    public Set<String> getContainerWithMaxOpType(String operationType) {
        if ("ADD".equals(operationType)) {
            return findMaxFrom(addOperationStats);
        } else if ("SUB".equals(operationType)) {
            return findMaxFrom(subOperationStats);
        }

        throw new IllegalArgumentException("Invalid operation type!");
    }

    public double squashCapacityFor(String name) {
        var temp = actionLog.stream()
                .filter(entry -> entry.getContainerName().equals(name))
                .sorted(Comparator.comparing(LogEntry::getCreated))
                .toList();

        double capacity = 0;
        for (var entry: temp) {
            if (entry.isSuccess() && entry.getOperationName().equals("ADD")) {
                capacity += entry.getDelta();
            } else if (entry.isSuccess() && entry.getOperationName().equals("SUB")) {
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
        if (!entry.getOperationName().equals("ADD")) {
            return;
        }

        calculate(addOperationStats, entry.getContainerName());
    }

    private void subOp(LogEntry entry) {
        if (!entry.getOperationName().equals("SUB")) {
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
