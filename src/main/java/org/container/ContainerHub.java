package org.container;

import java.util.*;

public class ContainerHub {
    private List<Container> containers = new ArrayList<>();
    private final Set<String> names = new HashSet<>();

    public void add(Container container) {
        final String name = container.getName();
        if (names.contains(name)) {
            throw new IllegalStateException("Container with name: " + name + " already exists!");
        }

        names.add(name);
        containers.add(container);
    }

    public Container findTheBiggestAmountOfWater() {
         return containers
             .stream()
             .max(Comparator.comparingDouble(Container::getActualCapacity))
             .orElse(null);
    }

    public Container findTheBiggestPercentageOfWater() {
        return containers
                .stream()
                .max(Comparator.comparingDouble(Container::getPercentage))
                .orElse(null);
    }

    public List<Container> findEmptyContainers() {
        return containers
            .stream()
            .filter(container -> container.getActualCapacity() == 0)
            .toList();
    }
}
