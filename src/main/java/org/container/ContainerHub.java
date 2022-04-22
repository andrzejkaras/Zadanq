package org.container;

import java.util.*;

/**
 * Container hub
 *
 * It could be used for storing containers independent of storage used.
 */
public interface ContainerHub {
    /**
     * Adds container
     * @param container new container
     */
    void add(Container container);

    /**
     * Returns actual capacity for given container
     *
     * @param name container name
     *
     * @return actual capacity
     */
    double getActualCapacityByName(String name);

    Container getByName(String name);
}
