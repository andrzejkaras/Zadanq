package org.applicationManager;

import org.junit.*;

import static org.junit.Assert.assertTrue;

public class ApplicationManagerTest {

    @Test
    public void name() {
        // given
        ApplicationManager applicationManager = ApplicationManagerFactory.get();

        applicationManager.createContainer("1");
        applicationManager.createContainer("2", 3);
        applicationManager.createContainer("3", 10);

        applicationManager.addWater("1", 1);
        applicationManager.addWater("2", 3);
        applicationManager.addWater("3", 10);

        applicationManager.removeWater("3", 5);

        applicationManager.swap("1", "3", 1);

        // when
        boolean resultOne = applicationManager.verifyState("1");
        boolean resultTwo = applicationManager.verifyState("2");
        boolean resultThree = applicationManager.verifyState("3");

        // then
        assertTrue(resultOne);
        assertTrue(resultTwo);
        assertTrue(resultThree);
    }
}
