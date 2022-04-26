package org.commandHandler.create;

import org.applicationManager.*;
import org.commons.*;

public  class CreateHandler implements OperationHandler<CreateContainerData> {
    private final ApplicationManager applicationManager;

    public CreateHandler(ApplicationManager applicationManager) {
        this.applicationManager = applicationManager;
    }

    @Override
    public boolean handle(Operation operation, CreateContainerData command) {
        boolean isSuccessful = applicationManager.createContainer(command);

        if (!isSuccessful) {
            System.out.println("Unknown OP or incorrect data");
        }

        return isSuccessful;
    }
}
