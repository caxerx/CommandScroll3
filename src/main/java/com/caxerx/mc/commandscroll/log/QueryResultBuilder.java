package com.caxerx.mc.commandscroll.log;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.TextComponent;

public class QueryResultBuilder {
    private ComponentBuilder layout;
    private TimeDisplayConfig timeDisplayConfig;

    public QueryResultBuilder(TimeDisplayConfig timeDisplayConfig) {
        this.timeDisplayConfig = timeDisplayConfig;
        layout = new ComponentBuilder("");
        layout.append("==== ").append("CommandScroll Log").color(ChatColor.AQUA).append(" ====").color(ChatColor.RESET).append("\n");
    }

    public QueryResultBuilder append(QueryResult res) {
        //caxerx used scroll_jj in world:x,y,z (10h ago)
        //(1337h ago) (20s ago) (3m ago)
        layout.append(res.getPlayerName()).color(ChatColor.GOLD).append(" used ").color(ChatColor.RESET).append(res.getScrollName())
                .color(ChatColor.GOLD).append(" in ").color(ChatColor.RESET).append(res.getWorld()).append(":")
                .append(String.valueOf(res.getX())).append(",").append(String.valueOf(res.getY()))
                .append(",").append(String.valueOf(res.getZ()))
                .append(" ").append(getFormattedTimeAgo(res.getTime(), timeDisplayConfig)).color(ChatColor.GRAY).italic(true).append("\n");
        return this;
    }


    public TextComponent build() {
        return new TextComponent(layout.create());
    }

    public String getFormattedTimeAgo(long time, TimeDisplayConfig timeConfig) {
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
