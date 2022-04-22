package org.verifier;

import org.container.ContainerHub;
import org.actionLog.ActionLog;

final class BasicStateVerifier implements StateVerifier {
    private final ContainerHub hub;
    private final ActionLog log;

    BasicStateVerifier(ContainerHub hub, ActionLog log) {
        this.hub = hub;
        this.log = log;
    }

    @Override
    public boolean check(String name) {
        var actual = hub.getActualCapacityByName(name);
        var squashed = log.findActualCapacity(name);

        return actual == squashed;
    }
}
