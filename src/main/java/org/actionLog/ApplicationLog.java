package org.actionLog;

import java.util.*;

public class ApplicationLog {
    private static final List<LogEntry> LOG = new ArrayList<>();

    public void append(LogEntry entry) {
        LOG.add(entry);
    }

    public Set<String> getContainerNameWithTheMostErrors(Set<String> names) {
        return null; // TODO: implement
    }
}
