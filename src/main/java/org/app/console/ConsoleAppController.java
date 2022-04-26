package org.app.console;

import org.commandHandler.create.*;
import org.dataTranslator.*;
import org.commons.*;
import org.operationsReceiver.*;

import java.util.*;


import static org.commons.Operation.EXIT;
import static org.commons.Operation.UNKNOWN;

// TODO: handle the rest op operations
// TODO: prepare class responsible for response preparation
public class ConsoleAppController {
    private static final ConsoleReader CONSOLE_READER = new ConsoleReader();
    private static final ConsoleWriter CONSOLE_WRITER = new ConsoleWriter();
    private static final OperationTranslator COMMAND_TRANSLATOR = new BasicOperationTranslator();

    private final Map<Operation, OperationHandler> operationHandlerMap;
    private final Map<Operation, DataTranslator> dataTranslatorMap;

    public ConsoleAppController(Map<Operation, OperationHandler> operationHandlerMap, Map<Operation, DataTranslator> dataTranslatorMap) {
        this.operationHandlerMap = operationHandlerMap;
        this.dataTranslatorMap =  dataTranslatorMap;
    }

    public void run() {
        while (true) {
            String commandLine = CONSOLE_READER.read();
            Operation operation = COMMAND_TRANSLATOR.translate(commandLine);

            if (UNKNOWN.equals(operation)) {
                System.out.println(CONSOLE_WRITER.write(operation));
                continue;
            }

            if (operation.equals(EXIT)) {
                System.out.println(CONSOLE_WRITER.write(operation));
                System.exit(0);
                return;
            }

            OperationHandler operationHandler = operationHandlerMap.get(operation);
            if (operationHandler != null) {
                DataTranslator dataTranslator = dataTranslatorMap.get(operation);

                if (dataTranslator != null) {
                    operationHandler.handle(operation, dataTranslator.translate(commandLine));
                }
            }
        }
    }
}

