package org.container;

import java.time.*;

public class Container {
    private static final double DEFAULT_MAX_CAPACITY = 5;

    private String name;

    private double actualCapacity;
    private double maxCapacity;

    public void addWater(double amount) {
        if (!canAdd(amount)) {
            return;
        }

        add(amount);
    }

    public void removeWater(double amount) {
        if (!canRemove(amount)) {
            return;
        }

        remove(amount);
    }

    public void swap(Container from, double amount) {
        if (!canSwap(from, amount)) {
            return;
        }

        from.remove(amount);
        this.add(amount);
    }

    @Override
    public String toString() {
        return "Container{" +
                "name='" + name + '\'' +
                ", actualCapacity=" + actualCapacity +
                '}';
    }

    private boolean canSwap(Container from, double amount) {
        return amount > 0 && from.canRemove(amount) && this.canAdd(amount);
    }

    private boolean canAdd(double amount) {
        return actualCapacity + amount <= maxCapacity;
    }

    private boolean canRemove(double amount) {
        return actualCapacity - amount >= 0;
    }

    private void add(double amount) {
        actualCapacity += amount;
    }

    private void remove(double amount) {
        actualCapacity -= amount;
    }

    // region Constructors

    public Container() {
        this.name = "Container-" + Instant.now();
        this.actualCapacity = 0;
        this.maxCapacity = DEFAULT_MAX_CAPACITY;
    }

    public Container(String name) {
        this.name = name;
        this.actualCapacity = 0;
        this.maxCapacity = DEFAULT_MAX_CAPACITY;
    }

    public Container(String name, double capacity) {
        this.name = name;
        this.actualCapacity = 0;
        this.maxCapacity = capacity;
    }

    // endregion

    // region Getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getActualCapacity() {
        return actualCapacity;
    }

    public void setActualCapacity(double actualCapacity) {
        this.actualCapacity = actualCapacity;
    }

    public double getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(double maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public double getPercentage() {
        return actualCapacity / maxCapacity;
    }

    // endregion
}
