package org.container;

public class ContainerHubFactory {
    public static ContainerHub get() {
        return new InMemoryContainerHub();
    }
}
