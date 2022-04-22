package org.actionLog;

public class ApplicationLogFactory {
    public static ApplicationLog get() {
        return new InMemoryLog();
    }
}
