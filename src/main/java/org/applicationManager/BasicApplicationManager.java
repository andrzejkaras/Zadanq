package org.applicationManager;

import org.actionLog.*;
import org.commons.*;
import org.container.*;
import org.logSerializer.*;
import org.verifier.*;

import java.util.*;

/**
 * Facade class for main API.
 */
class BasicApplicationManager implements ApplicationManager {
    private final ContainerHub containerHub;
    private final ActionLog actionLog;
    private final StateVerifier verifier;
    private final LogSerializer logSerializer;

    public BasicApplicationManager(ContainerHub hub, ActionLog actionLog, StateVerifier verifier, LogSerializer logSerializer) {
        this.containerHub = hub;
        this.actionLog = actionLog;
        this.verifier = verifier;
        this.logSerializer = logSerializer;
    }

    public boolean createContainer(CreateContainerData data) {
        Container container = new Container(data.getName());
        return containerHub.add(container);
    }

    public boolean addWater(String name, double amountOfWater) {
        Container container = containerHub.getByName(name);
        final boolean isSuccessful = container.addWater(amountOfWater);
        actionLog.append(new LogEntry(Operation.ADD, name, amountOfWater, isSuccessful));
        return isSuccessful;
    }

    public boolean removeWater(String name, double amountOfWater) {
        Container container = containerHub.getByName(name);
        final boolean isSuccessful =  container.removeWater(amountOfWater);
        actionLog.append(new LogEntry(Operation.SUB, name, amountOfWater, isSuccessful));
        return isSuccessful;
    }

    public boolean swap(String from, String to, double amountOfWater) {
        Container fromContainer = containerHub.getByName(from);
        Container toContainer = containerHub.getByName(to);

        if (fromContainer != null && toContainer != null) {
            boolean isSuccessful = toContainer.swap(fromContainer, amountOfWater);

            actionLog.append(new LogEntry(Operation.SUB, from, amountOfWater, isSuccessful));
            actionLog.append(new LogEntry(Operation.ADD, to, amountOfWater, isSuccessful));

            return isSuccessful;
        }

        return false;
    }

    public boolean verifyState(String name) {
        return this.verifier.check(name);
    }

    public ContainerStatsProvider getStatsProvider() {
        return (ContainerStatsProvider) containerHub;
    }

    public EventStatsProvider getEventStatsProvider() {
        return (EventStatsProvider) actionLog;
    }

    @Override
    public boolean saveLog(String filename) {
        List<LogEntry> entries = this.actionLog.getData();
        return this.logSerializer.save(entries, filename);
    }
}
