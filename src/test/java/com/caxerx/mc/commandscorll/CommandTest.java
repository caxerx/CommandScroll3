package com.caxerx.mc.commandscorll;

import com.caxerx.mc.commandscroll.command.display.TimeDisplayConfig;
import com.caxerx.mc.commandscroll.logging.query.QueryResult;
import com.caxerx.mc.commandscroll.logging.query.condition.ConditionParser;
import com.caxerx.mc.commandscroll.logging.query.condition.EqualDatabaseCondition;
import com.caxerx.mc.commandscroll.logging.query.condition.RangeDatabaseCondition;
import com.caxerx.mc.commandscroll.logging.query.condition.TimeDatabaseCondition;
import org.junit.Test;

public class CommandTest {
    @Test
    public void commandTest() {
        String commandArgs = "t:1d22h33m24s r:8 s:scrollname";
        String commandArgs2 = "t:33m24s";
        String commandArgs3 = "t:72h p:caxerx w:gasm";
        ConditionParser parser = new ConditionParser();
        parser.registerCondition(new RangeDatabaseCondition());
        parser.registerCondition(new TimeDatabaseCondition());
        parser.registerCondition(new EqualDatabaseCondition("s", "scroll_name"));
        parser.registerCondition(new EqualDatabaseCondition("p", "player_name"));
        parser.registerCondition(new EqualDatabaseCondition("w", "world"));
        System.out.println(parser.toSql(commandArgs.split(" "), new FakePlayer()));
        System.out.println(parser.toSql(commandArgs2.split(" "), new FakePlayer()));
        System.out.println(parser.toSql(commandArgs3.split(" "), new FakePlayer()));
    }

    @Test
    public void commandFormat() {
    }
}
