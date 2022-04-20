package org.container;

import java.util.*;

public class ContainerHub {
    private static final List<Container> CONTAINERS = new ArrayList<>();
    private static final Set<String> NAMES = new HashSet<>();

    public void add(Container container) {
        final String name = container.getName();
        if (NAMES.contains(name)) {
            throw new IllegalStateException("Container with name: " + name + " already exists!");
        }

        NAMES.add(name);
        CONTAINERS.add(container);
    }

    public Container findTheBiggestAmountOfWater() {
         return CONTAINERS
             .stream()
             .max(Comparator.comparingDouble(Container::getActualCapacity))
             .orElse(null);
    }

    public Container findTheBiggestPercentageOfWater() {
        return CONTAINERS
                .stream()
                .max(Comparator.comparingDouble(Container::getPercentage))
                .orElse(null);
    }

    public List<Container> findEmptyContainers() {
        return CONTAINERS
            .stream()
            .filter(container -> container.getActualCapacity() == 0)
            .toList();
    }
}
