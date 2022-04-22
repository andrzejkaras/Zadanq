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
     * Returns container with the biggest amount of water
     * @return container
     */
    Container findTheBiggestAmountOfWater();

    /**
     * Returns container with the biggest percentage of water
     * @return container
     */
    Container findTheBiggestPercentageOfWater();

    /**
     * Returns list of empty containers
     * @return empty containers as list
     */
    List<Container> findEmptyContainers();

    /**
     * Returns actual capacity for given container
     *
     * @param name container name
     *
     * @return actual capacity
     */
    double getActualCapacityByName(String name);
}
