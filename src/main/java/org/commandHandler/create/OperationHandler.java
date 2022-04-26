package org.commandHandler.create;

import org.commons.*;

public interface OperationHandler<T> {
    boolean handle(Operation operation, T command);
}
