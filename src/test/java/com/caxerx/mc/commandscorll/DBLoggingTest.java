package com.caxerx.mc.commandscorll;

import com.caxerx.mc.commandscroll.logging.log.ScrollLogger;
import com.caxerx.mc.commandscroll.scroll.Scroll;
import org.junit.Test;

import java.io.File;

public class DBLoggingTest {
    @Test
    public void testLog() {
        ScrollLogger logger = new ScrollLogger(new File("./log.db"));
        for (int i = 0; i < 5000; i++) {
            logger.log(new FakePlayer(), new Scroll(String.valueOf((int) (Math.random() * 100))));
        }
    }
}
