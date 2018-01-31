package com.caxerx.mc.commandscroll.log;

import com.caxerx.mc.commandscroll.Registrable;
import org.bukkit.entity.Player;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimeDatabaseCondition implements Registrable {
    private static Pattern timePattern = Pattern.compile("((?<day>\\d+)d)?((?<hour>\\d+)h)?((?<minute>\\d+)m)?((?<second>\\d+)s)?");

    @Override
    public String parse(String original, Player player) {
        Timestamp currentlyTime = new Timestamp(System.currentTimeMillis());
        Matcher timeMatcher = timePattern.matcher(original.replace("t:", ""));
        timeMatcher.matches();
        long second = Long.parseLong(Optional.ofNullable(timeMatcher.group("second")).orElse("0"));
        long minute_to_sec = Long.parseLong(Optional.ofNullable(timeMatcher.group("minute")).orElse("0")) * 60;
        long hour_to_sec = Long.parseLong(Optional.ofNullable(timeMatcher.group("hour")).orElse("0")) * 60 * 60;
        long day_to_sec = Long.parseLong(Optional.ofNullable(timeMatcher.group("day")).orElse("0")) * 60 * 60 * 24;
        Instant currentlyInstant = currentlyTime.toInstant().minusSeconds(second).minusSeconds(minute_to_sec).minusSeconds(hour_to_sec).minusSeconds(day_to_sec);
        return "use_time >= " + currentlyInstant.getEpochSecond();
    }

    @Override
    public boolean match(String original) {
        return original.startsWith("t:") && timePattern.matcher(original.replaceFirst("t:", "")).matches();
    }

    @Override
    public String getId() {
        return "t";
    }
}
