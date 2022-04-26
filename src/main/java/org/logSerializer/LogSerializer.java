package org.logSerializer;

import org.actionLog.*;

import java.util.*;

public interface LogSerializer {
    boolean save(List<LogEntry> entryLog, String fileName);
}
