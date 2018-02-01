package com.caxerx.mc.commandscorll;

import com.caxerx.mc.commandscroll.placeholder.PlaceholderParser;
import com.caxerx.mc.commandscroll.placeholder.PlayerFunctionPlaceholder;
import com.caxerx.mc.commandscroll.placeholder.VariableManager;
import com.caxerx.mc.commandscroll.placeholder.VariablePlaceholder;
import org.bukkit.entity.HumanEntity;
import org.junit.Test;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegexTest {
    @Test
    public void placeholderRegex() {
        PlaceholderParser cps = new PlaceholderParser();
        cps.registerPlaceholder(new PlayerFunctionPlaceholder("name", HumanEntity::getName));
        VariableManager varm = new VariableManager();
        varm.put("victim", "SlenderDan");
        cps.registerPlaceholder(new VariablePlaceholder());

        System.out.println(cps.parse("/tp <var:victim> <name>", new FakePlayer()));
    }


    @Test
    public void timeRegex() {
        Pattern pattern = Pattern.compile("((?<day>\\d+)d)?((?<hour>\\d+)h)?((?<minute>\\d+)m)?((?<second>\\d+)s)?");
        Matcher m1 = pattern.matcher("1d1h");
        System.out.println(m1.matches());
        System.out.println("m1: " + m1.groupCount());
        System.out.println(Optional.ofNullable(m1.group("day")).orElse("0"));
        System.out.println(Optional.ofNullable(m1.group("hour")).orElse("0"));
        System.out.println(Optional.ofNullable(m1.group("minute")).orElse("0"));
        System.out.println(Optional.ofNullable(m1.group("second")).orElse("0"));
        Timestamp time = new Timestamp(System.currentTimeMillis());
        long second = Long.parseLong(Optional.ofNullable(m1.group("second")).orElse("0"));
        long minute_to_sec = Long.parseLong(Optional.ofNullable(m1.group("minute")).orElse("0")) * 60;
        long hour_to_sec = Long.parseLong(Optional.ofNullable(m1.group("hour")).orElse("0")) * 60 * 60;
        long day_to_sec = Long.parseLong(Optional.ofNullable(m1.group("day")).orElse("0")) * 60 * 60 * 24;
        Instant timeins = time.toInstant().minusSeconds(second).minusSeconds(minute_to_sec).minusSeconds(hour_to_sec).minusSeconds(day_to_sec);
        System.out.println(timeins.toEpochMilli());
    }
}
