package org.app.console;

import org.applicationManager.*;
import org.commandHandler.create.*;
import org.commandHandler.saveToFile.*;
import org.dataTranslator.*;
import org.commons.*;
import org.dataTranslator.create.*;
import org.dataTranslator.saveToFile.*;

import java.util.*;

import static org.commons.Operation.CREATE;
import static org.commons.Operation.SAVE_TO_FILE;

public class ConsoleAppControllerFactory {
    public static ConsoleAppController get() {
        Map<Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(CREATE, new CreateHandler(ApplicationManagerFactory.get()));
        operationHandlerMap.put(SAVE_TO_FILE, new SaveToFileHandler(ApplicationManagerFactory.get()));

        Map<Operation, DataTranslator> dataTranslatorMap = new HashMap<>();
        dataTranslatorMap.put(CREATE, new CreateDataTranslator(new CreateValidator(), new CreateDataParser()));
        dataTranslatorMap.put(SAVE_TO_FILE, new SaveToFileTranslator(new SaveToFileValidator(), new SaveToFileParser()));

        return new ConsoleAppController(operationHandlerMap, dataTranslatorMap);
    }
}
