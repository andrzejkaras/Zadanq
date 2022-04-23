package org.container;

import java.util.*;

final class InMemoryContainerHub implements ContainerHub, ContainerStatsProvider {
    private final List<Container> containers;
    private final Set<String> name;

    InMemoryContainerHub() {
        this.containers = new ArrayList<>();
        this.name = new HashSet<>();
    }

    @Override
    public boolean add(Container container) {
        final String name = container.getName();
        if (this.name.contains(name)) {
            return false;
        }

        this.name.add(name);
        containers.add(container);
        return true;
    }

    @Override
    public Container findTheBiggestAmountOfWater() {
         return containers
             .stream()
             .max(Comparator.comparingDouble(Container::getActualCapacity))
             .orElse(null);
    }

    @Override
    public Container findTheBiggestPercentageOfWater() {
        return containers
                .stream()
                .max(Comparator.comparingDouble(Container::getPercentage))
                .orElse(null);
    }

    @Override
    public List<Container> findEmptyContainers() {
        return containers
            .stream()
            .filter(container -> container.getActualCapacity() == 0)
            .toList();
    }

    @Override
    public double getActualCapacityByName(String name) {
        var temp = getByName(name);
        if (temp != null) {
            return temp.getActualCapacity();
        }

        throw new IllegalArgumentException("Invalid name!");
    }

    @Override
    public Container getByName(String name) {
        return containers.stream()
            .filter(container -> container.getName().equals(name)).findFirst()
            .orElse(null);
    }
}
