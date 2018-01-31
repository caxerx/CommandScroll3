package com.caxerx.mc.commandscorll;

import com.caxerx.mc.commandscroll.log.ScrollLogger;
import org.junit.Test;

import java.io.File;

public class DBLoggingTest {
    @Test
    public void testLog() {
        ScrollLogger logger = new ScrollLogger(new File("./log.db"));
        for (int i = 0; i < 5000; i++) {
            logger.log(null, null);
        }
    }
}
