package org.operationsReceiver;

import org.commons.*;

public class ConsoleWriter {

    public String write(Operation operation) {
        return switch (operation) {
            case EXIT -> "Going away :)";
            case UNKNOWN -> "Unknown operation. Please pass correct one";
            default -> null;
        };
    }
}
