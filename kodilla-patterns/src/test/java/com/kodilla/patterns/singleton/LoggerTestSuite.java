package com.kodilla.patterns.singleton;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class LoggerTestSuite {
    @Test
    public void testGetLastLog() {
        Logger.getInstance().log("First log");

        String result = Logger.getInstance().getLastLog();

        Assert.assertEquals("First log", result);
    }
}
