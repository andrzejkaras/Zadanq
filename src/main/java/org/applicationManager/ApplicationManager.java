package org.applicationManager;

import org.actionLog.*;
import org.container.*;

public interface ApplicationManager {
    boolean createContainer(String name);
    boolean createContainer(String name, double capacity);
    boolean addWater(String name, double amountOfWater);
    boolean removeWater(String name, double amountOfWater);
    boolean swap(String from, String to, double amountOfWater);
    boolean verifyState(String name);
    ContainerStatsProvider getStatsProvider();
    EventStatsProvider getEventStatsProvider();
}
