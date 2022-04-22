package org;

import org.actionLog.*;
import org.container.*;
import org.applicationManager.*;
import org.verifier.*;

public class App {
    public static void main( String[] args ) {
        ContainerHub hub = ContainerHubFactory.get();
        ActionLog log = ActionLogFactory.get();

        ApplicationManager applicationManager = new ApplicationManager(hub, log, StateVerifierFactory.get(hub, log));

        applicationManager.createContainer("1");
        applicationManager.createContainer("2", 3);
        applicationManager.createContainer("3", 10);

        applicationManager.addWater("1", 4);
        applicationManager.addWater("2", 1);
        applicationManager.swap("2", "1", 2);

        ContainerStatsProvider containerStatsProvider = applicationManager.getStatsProvider();

        var highAmountOfWater = containerStatsProvider.findTheBiggestAmountOfWater();
        var highPercentageOfWater = containerStatsProvider.findTheBiggestPercentageOfWater();
        var empties = containerStatsProvider.findEmptyContainers();

        EventStatsProvider eventStatsProvider = applicationManager.getEventStatsProvider();

        var maxErrors = eventStatsProvider.getContainerNameWithTheMostErrors();
        var maxAddOp = eventStatsProvider.getContainerWithMaxOpType("ADD");
        var maxSubOp = eventStatsProvider.getContainerWithMaxOpType("SUB");

        var containerOneIsOk = applicationManager.verifyState("1");
        var containerTwoIsOk = applicationManager.verifyState("2");
        var containerThreeIsOk = applicationManager.verifyState("3");
    }
}
