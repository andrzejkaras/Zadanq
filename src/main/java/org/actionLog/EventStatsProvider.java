package org.actionLog;

import org.commons.*;

import java.util.*;

public interface EventStatsProvider {
    /**
     * Retrieves names of containers that have the biggest amount of errors.
     * @return set of container's names
     */
    Set<String> getContainerNameWithTheMostErrors();

    /**
     * Retrieves names of containers that have the biggest amount of operations.
     * @param operationType operation type
     * @return set of container's names
     */
    Set<String> getContainerWithMaxOpType(Operation operationType);
}
