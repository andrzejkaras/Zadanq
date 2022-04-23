package org.container;

/**
 * Container hub
 *
 * It could be used for storing containers independent of storage used.
 */
public interface ContainerHub {
    /**
     * Adds container
     * @param container new container
     *
     * @return true when operation was successful, false otherwise
     */
    boolean add(Container container);

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
