package org.operationsReceiver;

import org.commons.*;

public interface OperationTranslator {
    Operation translate(String commandLine);
}
