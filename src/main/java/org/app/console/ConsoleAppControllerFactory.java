package org.app.console;

import org.applicationManager.*;
import org.commandHandler.*;
import org.commandHandler.create.*;
import org.commandHandler.saveToFile.*;
import org.dataTranslator.*;
import org.commons.*;
import org.dataTranslator.addWater.*;
import org.dataTranslator.create.*;
import org.dataTranslator.saveToFile.*;

import java.util.*;

import static org.commons.Operation.ADD;
import static org.commons.Operation.CREATE;
import static org.commons.Operation.SAVE_TO_FILE;

public class ConsoleAppControllerFactory {
    public static ConsoleAppController get() {
        Map<Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        ApplicationManager applicationManager = ApplicationManagerFactory.get();
        operationHandlerMap.put(CREATE, new CreateHandler(applicationManager));
        operationHandlerMap.put(SAVE_TO_FILE, new SaveToFileHandler(applicationManager));
        operationHandlerMap.put(ADD, new AddWaterHandler(applicationManager));

        Map<Operation, DataTranslator> dataTranslatorMap = new HashMap<>();
        dataTranslatorMap.put(CREATE, new CreateDataTranslator(new CreateValidator(), new CreateDataParser()));
        dataTranslatorMap.put(SAVE_TO_FILE, new SaveToFileTranslator(new SaveToFileValidator(), new SaveToFileParser()));
        dataTranslatorMap.put(ADD, new AddWaterTranslator(new AddWaterValidator(), new AddWaterParser()));

        return new ConsoleAppController(operationHandlerMap, dataTranslatorMap);
    }
}
