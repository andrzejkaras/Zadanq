package org.actionLog;

import org.junit.*;

import java.time.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ApplicationLogTest {

    @Test
    public void Given_EventLogWithEntries_WhenWeAskForErrors_ContainerThreeShouldBeReturned() {
        // given
        InMemoryLog log = new InMemoryLog();

        // when
        log.append(new LogEntry(Instant.now(), "ADD", "1", 4));
        log.append(new LogEntry(Instant.now(), "ADD", "2", 1));

        log.append(new LogEntry(Instant.now(), "SUB", "1", 2));
        log.append(new LogEntry(Instant.now(), "ADD", "2", 2));

        var errorLog = new LogEntry(Instant.now(), "ADD", "3", 2);
        errorLog.setSuccess(false);

        log.append(errorLog);

        var result = log.getContainerNameWithTheMostErrors();

        // then
        assertTrue("Container with errors should be equals 3", result.contains("3"));
        assertEquals("Result should contain one container name", 1, result.size());
    }

    @Test
    public void Given_EventLogWithEntries_WhenWeAskForAddAction_ContainerTwoShouldBeReturned() {
        // given
        InMemoryLog log = new InMemoryLog();

        // when
        log.append(new LogEntry(Instant.now(), "ADD", "1", 4));
        log.append(new LogEntry(Instant.now(), "ADD", "2", 1));

        log.append(new LogEntry(Instant.now(), "SUB", "1", 2));
        log.append(new LogEntry(Instant.now(), "ADD", "2", 2));

        var errorLog = new LogEntry(Instant.now(), "ADD", "3", 2);
        errorLog.setSuccess(false);

        log.append(errorLog);

        var result = log.getContainerWithMaxOpType("ADD");

        // then
        assertTrue("Container with the biggest amount of ADD actions", result.contains("2"));
        assertEquals("Result should contain one container name", 1, result.size());
    }

    @Test
    public void Given_EventLogWithEntries_WhenWeAskForSubAction_ContainerOneShouldBeReturned() {
        // given
        InMemoryLog log = new InMemoryLog();

        // when
        log.append(new LogEntry(Instant.now(), "ADD", "1", 4));
        log.append(new LogEntry(Instant.now(), "ADD", "2", 1));

        log.append(new LogEntry(Instant.now(), "SUB", "1", 2));
        log.append(new LogEntry(Instant.now(), "ADD", "2", 2));

        var errorLog = new LogEntry(Instant.now(), "ADD", "3", 2);
        errorLog.setSuccess(false);

        log.append(errorLog);

        var result = log.getContainerWithMaxOpType("SUB");

        // then
        assertTrue("Container with the biggest amount of SUB actions", result.contains("1"));
        assertEquals("Result should contain one container name", 1, result.size());
    }

    @Test
    public void Given_EventLogWithEntries_WhenWeAskForSubAction_SquashedAmountOfWaterShouldBeCorrect() {
        // given
        InMemoryLog log = new InMemoryLog();

        // when
        log.append(new LogEntry(Instant.now(), "ADD", "1", 4));
        log.append(new LogEntry(Instant.now(), "ADD", "2", 1));

        log.append(new LogEntry(Instant.now(), "SUB", "1", 2));
        log.append(new LogEntry(Instant.now(), "ADD", "2", 2));

        var errorLog = new LogEntry(Instant.now(), "ADD", "3", 2);
        errorLog.setSuccess(false);

        log.append(errorLog);

        var capacity = log.findActualCapacity("2");

        // then
        assertEquals( 3.0, capacity, 0.001);
    }
}
