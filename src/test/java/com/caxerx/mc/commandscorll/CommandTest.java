package com.caxerx.mc.commandscorll;

import com.caxerx.mc.commandscroll.log.*;
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
        System.out.println(parser.toSql(commandArgs.split(" "), null));
        System.out.println(parser.toSql(commandArgs2.split(" "), null));
        System.out.println(parser.toSql(commandArgs3.split(" "), null));
    }

    @Test
    public void commandFormat() {
        QueryResult qta = new QueryResult("caxerx", "jscroll", "mkworld", 0, 0, 0, System.currentTimeMillis());
        QueryResultBuilder qrb = new QueryResultBuilder(new TimeDisplayConfig("d", "h", "m", "s", "(<time> ago)"));
        qrb.append(qta).append(qta).append(qta).append(qta).append(qta).append(qta).append(qta);
        System.out.println(qrb.build().toPlainText());
    }
}
