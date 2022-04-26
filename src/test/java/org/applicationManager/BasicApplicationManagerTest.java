package org.applicationManager;

import org.commons.*;
import org.junit.*;

import static org.junit.Assert.assertTrue;

public class BasicApplicationManagerTest {

    @Test
    public void name() {
        // given
        ApplicationManager basicApplicationManager = ApplicationManagerFactory.get();

        basicApplicationManager.createContainer(new CreateContainerData("1", 3));
        basicApplicationManager.createContainer(new CreateContainerData("2", 3));
        basicApplicationManager.createContainer(new CreateContainerData("3", 10));

        basicApplicationManager.addWater("1", 1);
        basicApplicationManager.addWater("2", 3);
        basicApplicationManager.addWater("3", 10);

        basicApplicationManager.removeWater("3", 5);

        basicApplicationManager.swap("1", "3", 1);

        // when
        boolean resultOne = basicApplicationManager.verifyState("1");
        boolean resultTwo = basicApplicationManager.verifyState("2");
        boolean resultThree = basicApplicationManager.verifyState("3");

        // then
        assertTrue(resultOne);
        assertTrue(resultTwo);
        assertTrue(resultThree);
    }
}
