package org.container;

import org.junit.*;

import static org.junit.Assert.assertEquals;

public class ContainerTest {

    @Test
    public void Given_SetOfContainers_When_DefinedOperationsWouldBeDone_Then_ContainerWithTheHighestAmountOfWaterIsEqualTo() {
        // given
        ContainerHub hub = new ContainerHub();
        var one = new Container("1");
        var two = new Container("2", 3);
        var three = new Container("3", 10);

        hub.add(one);
        hub.add(two);
        hub.add(three);

        // when
        one.addWater(4);
        two.addWater(1);
        two.swap(one, 2);

        var highAmountOfWater = hub.findTheBiggestAmountOfWater();

        // then
        assertEquals("Container with the highest amount of water", "2", highAmountOfWater.getName());
    }

    @Test
    public void Given_SetOfContainers_When_DefinedOperationsWouldBeDone_Then_ContainerWithTheHighestPercentageOfWaterIsEqualTo() {
        // given
        ContainerHub hub = new ContainerHub();
        var one = new Container("1");
        var two = new Container("2", 3);
        var three = new Container("3", 10);

        hub.add(one);
        hub.add(two);
        hub.add(three);

        // when
        one.addWater(4);
        two.addWater(1);
        two.swap(one, 2);

        var highPercentageOfWater = hub.findTheBiggestPercentageOfWater();

        // then
        assertEquals("Container with the highest amount of water", "2", highPercentageOfWater.getName());
    }

    @Test
    public void Given_SetOfContainers_When_DefinedOperationsWouldBeDone_Then_EmptyContainersAre() {
        // given
        ContainerHub hub = new ContainerHub();
        var one = new Container("1");
        var two = new Container("2", 3);
        var three = new Container("3", 10);

        hub.add(one);
        hub.add(two);
        hub.add(three);

        // when
        one.addWater(4);
        two.addWater(1);
        two.swap(one, 2);

        var highPercentageOfWater = hub.findEmptyContainers();

        // then
        assertEquals("Container with the highest amount of water", 1, highPercentageOfWater.size());
        assertEquals("Container with the highest amount of water", "3", highPercentageOfWater.get(0).getName());
    }

    @Test
    public void Given_SetOfContainers_When_DefinedOperationsWouldBeDone_Then_ContainersShouldHaveCorrectAmountOfWater() {
        // given
        ContainerHub hub = new ContainerHub();
        var one = new Container("1");
        var two = new Container("2", 3);
        var three = new Container("3", 10);

        hub.add(one);
        hub.add(two);
        hub.add(three);

        // when
        one.addWater(4);
        two.addWater(1);
        two.swap(one, 2);

        var capacity = hub.getActualCapacityByName("2");

        // then
        assertEquals( 3.0, capacity, 0.001);
    }
}
