package org.commandHandler.saveToFile;

import org.applicationManager.*;
import org.commandHandler.create.*;
import org.commons.*;

public class SaveToFileHandler implements OperationHandler<SaveToFileData> {
    private final ApplicationManager manager;

    public SaveToFileHandler(ApplicationManager applicationManager) {
        this.manager = applicationManager;
    }

    @Override
    public boolean handle(Operation operation, SaveToFileData command) {
        return manager.saveLog(command.getFilename());
    }
}
