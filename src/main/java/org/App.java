package org;

import org.container.*;

public class App
{
    public static void main( String[] args ) {
        var one = new Container("1");
        var two = new Container("2", 3);
        var three = new Container("3", 10);

        ContainerHub hub = new ContainerHub();
        hub.add(one);
        hub.add(two);
        hub.add(three);

        one.addWater(4);
        two.addWater(1);
        two.swap(one, 2);

        System.out.println(one);
        System.out.println(two);
        System.out.println(three);

        var highAmountOfWater = hub.findTheBiggestAmountOfWater();
        var highPercentageOfWater = hub.findTheBiggestPercentageOfWater();
        var empties = hub.findEmptyContainers();
    }
}
