package org.operationsReceiver;

import org.commons.*;

import static org.commons.Operation.UNKNOWN;

public class BasicOperationTranslator implements OperationTranslator {
    private static final String COMMAND_SEPARATOR = ":";

    @Override
    public Operation translate(String commandLine) {
        if (!commandLine.contains(COMMAND_SEPARATOR)) {
            return UNKNOWN;
        }

        String[] splitCommandLine = commandLine.split(COMMAND_SEPARATOR);
        String temp = splitCommandLine[0].toUpperCase();
        return Operation.safeValueOf(temp);
    }
}
