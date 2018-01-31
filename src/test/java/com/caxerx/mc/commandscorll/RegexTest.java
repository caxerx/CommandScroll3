package com.caxerx.mc.commandscorll;

import com.caxerx.mc.commandscroll.placeholder.CommandParser;
import com.caxerx.mc.commandscroll.Registrable;
import org.bukkit.entity.Player;
import org.junit.Test;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegexTest {
    @Test
    public void placeholderRegex() {
        CommandParser cps = new CommandParser();
        cps.registerPlaceholder(new Registrable() {
            @Override
            public String parse(String original, Player player) {
                return "caxerx";
            }

            @Override
            public boolean match(String original) {
                if (original.equals("<player>")) {
                    return true;
                }
                return false;
            }

            @Override
            public String getId() {
                return "player";
            }
        });

        System.out.println(cps.parse("/setlocation <player> 13 133 23", null));
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
