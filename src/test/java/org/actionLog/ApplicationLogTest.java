package org.actionLog;

import org.commons.*;
import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ApplicationLogTest {

    @Test
    public void Given_EventLogWithEntries_WhenWeAskForErrors_ContainerThreeShouldBeReturned() {
        // given
        InMemoryLog log = new InMemoryLog();

        // when
        log.append(new LogEntry(Operation.ADD, "1", 4, true));
        log.append(new LogEntry(Operation.ADD, "2", 1, true));

        log.append(new LogEntry(Operation.SUB, "1", 2, true));
        log.append(new LogEntry(Operation.ADD, "2", 2, true));

        log.append(new LogEntry(Operation.ADD, "3", 2, false));

        var containersWithErrors = log.getContainerNameWithTheMostErrors();

        // then
        assertTrue("Container with errors should be equals 3", containersWithErrors.contains("3"));
        assertEquals("Result should contain one container name", 1, containersWithErrors.size());
    }

    @Test
    public void Given_EventLogWithEntries_WhenWeAskForAddAction_ContainerTwoShouldBeReturned() {
        // given
        InMemoryLog log = new InMemoryLog();

        // when
        log.append(new LogEntry(Operation.ADD, "1", 4, true));
        log.append(new LogEntry(Operation.ADD, "2", 1, true));

        log.append(new LogEntry(Operation.SUB, "1", 2, true));
        log.append(new LogEntry(Operation.ADD, "2", 2, true));

        log.append(new LogEntry(Operation.ADD, "3", 2, true));

        var containersWithAddOps = log.getContainerWithMaxOpType(Operation.ADD);

        // then
        assertTrue("Container with the biggest amount of ADD actions", containersWithAddOps.contains("2"));
        assertEquals("Result should contain one container name", 1, containersWithAddOps.size());
    }

    @Test
    public void Given_EventLogWithEntries_WhenWeAskForSubAction_ContainerOneShouldBeReturned() {
        // given
        InMemoryLog log = new InMemoryLog();

        // when
        log.append(new LogEntry(Operation.ADD, "1", 4, true));
        log.append(new LogEntry(Operation.ADD, "2", 1, true));

        log.append(new LogEntry(Operation.SUB, "1", 2, true));
        log.append(new LogEntry(Operation.ADD, "2", 2, true));

        log.append(new LogEntry(Operation.ADD, "3", 2, true));

        var result = log.getContainerWithMaxOpType(Operation.SUB);

        // then
        assertTrue("Container with the biggest amount of SUB actions", result.contains("1"));
        assertEquals("Result should contain one container name", 1, result.size());
    }

    @Test
    public void Given_EventLogWithEntries_WhenWeAskForSubAction_SquashedAmountOfWaterShouldBeCorrect() {
        // given
        InMemoryLog log = new InMemoryLog();

        // when
        log.append(new LogEntry(Operation.ADD, "1", 4, true));
        log.append(new LogEntry(Operation.ADD, "2", 1, true));

        log.append(new LogEntry(Operation.SUB, "1", 2, true));
        log.append(new LogEntry(Operation.ADD, "2", 2, true));

        log.append(new LogEntry(Operation.ADD, "3", 2, true));

        var actualCapacity = log.findActualCapacity("2");

        // then
        assertEquals( 3.0, actualCapacity, 0.001);
    }
}
