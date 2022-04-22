package org.verifier;

import org.actionLog.*;
import org.container.*;

public class StateVerifierFactory {
    public static StateVerifier get(ContainerHub hub, ActionLog log) {
        return new BasicStateVerifier(hub, log);
    }
}
