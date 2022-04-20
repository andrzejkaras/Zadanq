package org.actionLog;

import java.util.*;

public class ApplicationLog {
    private static final List<LogEntry> LOG = new ArrayList<>();

    private static final Map<String, Integer> errors = new HashMap<>();
    private static final Map<String, Integer> addOp = new HashMap<>();
    private static final Map<String, Integer> subOp = new HashMap<>();

    public void append(LogEntry entry) {
        LOG.add(entry);
        error(entry);

        addOp(entry);
        subOp(entry);
    }

    public Set<String> getContainerNameWithTheMostErrors() {
        return findMaxFrom(errors);
    }

    public Set<String> getContainerWithMaxOpType(String operationType) {
        if ("ADD".equals(operationType)) {
            return findMaxFrom(addOp);
        } else if ("SUB".equals(operationType)) {
            return findMaxFrom(subOp);
        }

        throw new IllegalArgumentException("Invalid operation type!");
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

        calculate(errors, entry.getContainerName());
    }

    private void addOp(LogEntry entry) {
        if (!entry.getOperationName().equals("ADD")) {
            return;
        }

        calculate(addOp, entry.getContainerName());
    }

    private void subOp(LogEntry entry) {
        if (!entry.getOperationName().equals("SUB")) {
            return;
        }

        calculate(subOp, entry.getContainerName());
    }

    private void calculate(Map<String, Integer> map, String container) {
        if (!map.containsKey(container)) {
            map.put(container, 1);
        } else {
            map.merge(container, 1, Integer::sum);
        }
    }
}
