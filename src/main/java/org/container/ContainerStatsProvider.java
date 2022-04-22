package org.container;

import java.util.*;

public interface ContainerStatsProvider {
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
}
