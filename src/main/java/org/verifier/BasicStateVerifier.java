package org.verifier;

import org.container.ContainerHub;
import org.actionLog.ApplicationLog;

final class BasicStateVerifier implements StateVerifier {
    private final ContainerHub hub;
    private final ApplicationLog log;

    BasicStateVerifier(ContainerHub hub, ApplicationLog log) {
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
