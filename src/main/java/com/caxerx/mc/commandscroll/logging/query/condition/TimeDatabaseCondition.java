package com.caxerx.mc.commandscroll.logging.query.condition;

import com.caxerx.mc.commandscroll.Registrable;
import lombok.NonNull;
import org.bukkit.entity.Player;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimeDatabaseCondition implements Registrable {
    private static Pattern timePattern = Pattern.compile("((?<day>\\d+)d)?((?<hour>\\d+)h)?((?<minute>\\d+)m)?((?<second>\\d+)s)?");

    @Override
    public String parse(@NonNull String original, @NonNull Player player) {
        long currentlyTime = System.currentTimeMillis();
        Matcher timeMatcher = timePattern.matcher(original.replace("t:", ""));
        timeMatcher.matches();
        long second_to_ms = Long.parseLong(Optional.ofNullable(timeMatcher.group("second")).orElse("0")) * 1000;
        long minute_to_ms = Long.parseLong(Optional.ofNullable(timeMatcher.group("minute")).orElse("0")) * 1000 * 60;
        long hour_to_ms = Long.parseLong(Optional.ofNullable(timeMatcher.group("hour")).orElse("0")) * 1000 * 60 * 60;
        long day_to_ms = Long.parseLong(Optional.ofNullable(timeMatcher.group("day")).orElse("0")) * 1000 * 60 * 60 * 24;
        return "use_time >= " + (currentlyTime - second_to_ms - minute_to_ms - hour_to_ms - day_to_ms);
    }

    @Override
    public boolean match(@NonNull String original) {
        return original.startsWith("t:") && timePattern.matcher(original.replaceFirst("t:", "")).matches();
    }

    @Override
    public String getId() {
        return "t";
    }
}
