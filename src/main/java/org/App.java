package org;

import org.actionLog.*;
import org.container.*;

import java.time.*;

public class App
{
    public static void main( String[] args ) {
        ContainerHub hub = new ContainerHub();
        ApplicationLog log = new ApplicationLog();

        var one = new Container("1");
        var two = new Container("2", 3);
        var three = new Container("3", 10);

        hub.add(one);
        hub.add(two);
        hub.add(three);

        one.addWater(4);
        log.append(new LogEntry(Instant.now(), "ADD", one.getName(), 4));

        two.addWater(1);
        log.append(new LogEntry(Instant.now(), "ADD", two.getName(), 1));

        // temp 4 test
        var temp = new LogEntry(Instant.now(), "ADD", two.getName(), 2);
        temp.setSuccess(false);

        two.swap(one, 2);
        log.append(new LogEntry(Instant.now(), "SUB", one.getName(), 2));
        log.append(temp);

        System.out.println(one);
        System.out.println(two);
        System.out.println(three);

        var highAmountOfWater = hub.findTheBiggestAmountOfWater();
        var highPercentageOfWater = hub.findTheBiggestPercentageOfWater();
        var empties = hub.findEmptyContainers();

        var res = log.getContainerNameWithTheMostErrors();
        var x = log.getContainerWithMaxOpType("ADD");
        var y = log.getContainerWithMaxOpType("SUB");
    }
}
