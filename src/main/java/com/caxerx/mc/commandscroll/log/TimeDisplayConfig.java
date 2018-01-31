package com.caxerx.mc.commandscroll.log;

import lombok.Data;

@Data
public class TimeDisplayConfig {
    private final String day;
    private final String hour;
    private final String minute;
    private final String second;
    private final String format;

    public TimeDisplayConfig(String day, String hour, String minute, String second, String format) {
        this.day = day;
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        this.format = format;
    }
}
