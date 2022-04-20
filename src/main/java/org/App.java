package org;

import org.container.*;

public class App
{
    public static void main( String[] args )
    {
        var one = new Container("1");
        var two = new Container("2", 3);

        one.addWater(4);
        two.addWater(1);
        two.swap(one, 2);

        System.out.println(one);
        System.out.println(two);
    }
}
