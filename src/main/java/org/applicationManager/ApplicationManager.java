package org.applicationManager;

import org.actionLog.*;
import org.commons.*;
import org.container.*;

public interface ApplicationManager {
    boolean createContainer(CreateContainerData opData);
    boolean addWater(String name, double amountOfWater);
    boolean removeWater(String name, double amountOfWater);
    boolean swap(String from, String to, double amountOfWater);
    boolean verifyState(String name);
    ContainerStatsProvider getStatsProvider();
    EventStatsProvider getEventStatsProvider();
    boolean saveLog(String fileName);
}
