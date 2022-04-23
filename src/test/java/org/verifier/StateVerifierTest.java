package org.verifier;

import org.actionLog.*;
import org.commons.*;
import org.container.*;
import org.junit.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StateVerifierTest {
    @Test
    public void Given_SetOfContainers_When_DefinedOperationsWouldBeDone_Then_AllContainersShouldHaveCorrectState() {
        // given
        boolean operationResult = false;
        ContainerHub hub = ContainerHubFactory.get();
        ActionLog log = ActionLogFactory.get();

        Container one = new Container("1");
        Container two = new Container("2", 3);
        Container three = new Container("3", 10);

        hub.add(one);
        hub.add(two);
        hub.add(three);

        operationResult = one.addWater(4);
        log.append(new LogEntry(Operation.ADD, one.getName(), 4, operationResult));

        operationResult = two.addWater(1);
        log.append(new LogEntry(Operation.ADD, two.getName(), 1, operationResult));

        operationResult = two.swap(one, 2);
        log.append(new LogEntry(Operation.SUB, one.getName(), 2, operationResult));
        log.append(new LogEntry(Operation.ADD, two.getName(), 2, operationResult));

        StateVerifier verifier = new BasicStateVerifier(hub, log);

        // when
        boolean containerOneHasValidState = verifier.check("1");
        boolean containerTwoHasValidState = verifier.check("2");
        boolean containerThreeHasValidState = verifier.check("3");

        // then
        assertTrue(containerOneHasValidState);
        assertTrue(containerTwoHasValidState);
        assertTrue(containerThreeHasValidState);
    }

    @Test
    public void Given_SetOfContainers_When_DefinedOperationsWouldBeDone_Then_OneContainerShouldHaveIncorrectState() {
        // given
        ContainerHub hub = ContainerHubFactory.get();
        ActionLog log = ActionLogFactory.get();

        Container one = new Container("1");
        Container two = new Container("2", 3);
        Container three = new Container("3", 10);

        hub.add(one);
        hub.add(two);
        hub.add(three);

        one.addWater(4);
        log.append(new LogEntry(Operation.ADD, one.getName(), 4, true));

        two.addWater(1);
        log.append(new LogEntry(Operation.ADD, two.getName(), 1, true));

        two.swap(one, 2);
        log.append(new LogEntry(Operation.SUB, one.getName(), 2, true));

        var temp = new LogEntry(Operation.ADD, two.getName(), 2, true);
        temp.setSuccess(false);
        log.append(temp);

        StateVerifier verifier = new BasicStateVerifier(hub, log);

        // when
        boolean containerOneHasValidState = verifier.check("1");
        boolean containerTwoHasValidState = verifier.check("2");
        boolean containerThreeHasValidState = verifier.check("3");

        // then
        assertTrue(containerOneHasValidState);
        assertFalse(containerTwoHasValidState);
        assertTrue(containerThreeHasValidState);
    }
}
