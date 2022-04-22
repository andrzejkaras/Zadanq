package org.actionLog;

public class ActionLogFactory {
    public static ActionLog get() {
        return new InMemoryLog();
    }
}
