package com.caxerx.mc.commandscroll.command.display;

import lombok.Data;
import lombok.NonNull;

@Data
public class TimeDisplayConfig {
    @NonNull
    private final String day;
    @NonNull
    private final String hour;
    @NonNull
    private final String minute;
    @NonNull
    private final String second;
    @NonNull
    private final String format;

    public TimeDisplayConfig(String day, String hour, String minute, String second, String format) {
        this.day = day;
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        this.format = format;
    }

    public String getFormattedTimeAgo(long lapsedTime) {
        String timeago;
        if (lapsedTime > 86400000) {
            timeago = (lapsedTime / 86400000) + day;
        } else if (lapsedTime > 3600000) {
            timeago = (lapsedTime / 3600000) + hour;
        } else if (lapsedTime > 60000) {
            timeago = (lapsedTime / 60000) + minute;
        } else {
            timeago = (lapsedTime / 1000) + second;
        }
        return format.replace("<time>", timeago);
    }
}
