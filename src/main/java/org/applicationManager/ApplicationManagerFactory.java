package org.applicationManager;

import org.actionLog.*;
import org.container.*;
import org.verifier.*;

public class ApplicationManagerFactory {
    public static ApplicationManager get() {
        ContainerHub hub = ContainerHubFactory.get();
        ActionLog log = ActionLogFactory.get();

        return new ApplicationManager(hub, log, StateVerifierFactory.get(hub, log));
    }
}
