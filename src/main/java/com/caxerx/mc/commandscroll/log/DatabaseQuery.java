package com.caxerx.mc.commandscroll.log;

public class DatabaseQuery {
    private TimeDisplayConfig timeConfig;

    public DatabaseQuery(TimeDisplayConfig timeConfig) {
        this.timeConfig = timeConfig;
    }

    public String getFormatedTimeAgo(long time) {
        long lapsedTime = System.currentTimeMillis() - time;
        String timeago;
        if (lapsedTime > 86400000) {
            timeago = (lapsedTime / 86400000) + timeConfig.getDay();
        } else if (lapsedTime > 3600000) {
            timeago = (lapsedTime / 3600000) + timeConfig.getHour();
        } else if (lapsedTime > 60000) {
            timeago = (lapsedTime / 60000) + timeConfig.getMinute();
        } else {
            timeago = (lapsedTime / 1000) + timeConfig.getSecond();
        }
        return timeConfig.getFormat().replace("<time>", timeago);
    }
}
