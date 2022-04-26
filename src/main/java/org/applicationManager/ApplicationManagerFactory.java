package org.applicationManager;

import org.actionLog.*;
import org.container.*;
import org.logSerializer.*;
import org.verifier.*;

public class ApplicationManagerFactory {
    public static ApplicationManager get() {
        ContainerHub hub = ContainerHubFactory.get();
        ActionLog log = ActionLogFactory.get();
        LogSerializer serializer = new FileLogSerializer();

        return new BasicApplicationManager(hub, log, StateVerifierFactory.get(hub, log), serializer);
    }
}
