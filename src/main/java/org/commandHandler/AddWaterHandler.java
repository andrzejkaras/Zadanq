package org.commandHandler;

import org.applicationManager.*;
import org.commandHandler.create.*;
import org.commons.*;

public class AddWaterHandler implements OperationHandler<AddWaterData> {
    private final ApplicationManager applicationManager;

    public AddWaterHandler(ApplicationManager applicationManager) {
        this.applicationManager = applicationManager;
    }

    @Override
    public boolean handle(Operation operation, AddWaterData command) {
        return applicationManager.addWater(command.getName(), command.getCapacity());
    }
}
