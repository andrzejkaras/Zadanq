package org.verifier;

import org.actionLog.*;
import org.container.*;

public class StateVerifier {
    private final ContainerHub hub;
    private final ApplicationLog log;

    public StateVerifier(ContainerHub hub, ApplicationLog log) {
        this.hub = hub;
        this.log = log;
    }

    public boolean check(String name) {
        var actual = hub.getActualCapacityByName(name);
        var squashed = log.squashCapacityFor(name);

        return actual == squashed;
    }
}
