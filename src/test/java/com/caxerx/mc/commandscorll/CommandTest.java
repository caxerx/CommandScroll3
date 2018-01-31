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
        //caxerx used scroll_jj in world:x,y,z (10h ago)
        //(1337h ago) (20s ago) (3m ago)
    }

    @Test
    public void timeFormat() {
        DatabaseQuery dtq = new DatabaseQuery(new TimeDisplayConfig("日", "小時", "分鐘", "秒", "在 <time> 之前"));
        System.out.println(dtq.getFormatedTimeAgo(1517376269370L));
        DatabaseQuery dtq2 = new DatabaseQuery(new TimeDisplayConfig("d", "h", "m", "s", "<time> ago"));
        System.out.println(dtq2.getFormatedTimeAgo(1517376269370L));
    }
}
