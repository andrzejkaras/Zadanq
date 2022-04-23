package org;

import org.actionLog.*;
import org.commons.*;
import org.container.*;
import org.applicationManager.*;

public class App {
    public static void main( String[] args ) {
        ApplicationManager basicApplicationManager = ApplicationManagerFactory.get();

        basicApplicationManager.createContainer("1");
        basicApplicationManager.createContainer("2", 3);
        basicApplicationManager.createContainer("3", 10);

        basicApplicationManager.addWater("1", 4);
        basicApplicationManager.addWater("2", 1);
        basicApplicationManager.swap("2", "1", 2);

        ContainerStatsProvider containerStatsProvider = basicApplicationManager.getStatsProvider();

        var highAmountOfWater = containerStatsProvider.findTheBiggestAmountOfWater();
        var highPercentageOfWater = containerStatsProvider.findTheBiggestPercentageOfWater();
        var empties = containerStatsProvider.findEmptyContainers();

        EventStatsProvider eventStatsProvider = basicApplicationManager.getEventStatsProvider();

        var maxErrors = eventStatsProvider.getContainerNameWithTheMostErrors();
        var maxAddOp = eventStatsProvider.getContainerWithMaxOpType(Operation.ADD);
        var maxSubOp = eventStatsProvider.getContainerWithMaxOpType(Operation.SUB);

        var containerOneIsOk = basicApplicationManager.verifyState("1");
        var containerTwoIsOk = basicApplicationManager.verifyState("2");
        var containerThreeIsOk = basicApplicationManager.verifyState("3");
    }
}
