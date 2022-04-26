package org.commons;

public enum Operation {
    ADD("ADD"),
    SUB("SUB"),


    CREATE("CREATE"),
    SAVE_TO_FILE("SAVE_TO_FILE"),
//    ADD_WATER("ADD_WATER"),
//    REMOVE_WATER("REMOVE_WATER"),
//    IS_VALID("IS_VALID"),
//    GET_ACTUAL("GET_ACTUAL"),

    // TODO: move technical one into lower level enum
    EXIT("EXIT"),
    UNKNOWN("EXIT");

    private final String operationName;

    Operation(String operationName) {
        this.operationName = operationName;
    }

    public String getOperationName() {
        return operationName;
    }

    public static Operation safeValueOf(String operation) {
        try {
            return Operation.valueOf(operation);
        } catch (Throwable t) {
            return UNKNOWN;
        }
    }
}
