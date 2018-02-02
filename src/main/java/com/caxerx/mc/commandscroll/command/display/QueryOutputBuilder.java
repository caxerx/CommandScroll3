package com.caxerx.mc.commandscroll.command.display;

import com.caxerx.mc.commandscroll.logging.query.QueryResult;
import lombok.NonNull;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.TextComponent;

public class QueryOutputBuilder {
    private ComponentBuilder layout;
    private TimeDisplayConfig timeDisplayConfig;

    public QueryOutputBuilder(@NonNull TimeDisplayConfig timeDisplayConfig) {
        this.timeDisplayConfig = timeDisplayConfig;
        layout = new ComponentBuilder("");
        layout.append("===== ").append("CommandScroll Log").color(ChatColor.AQUA).append(" =====").color(ChatColor.RESET).append("\n");
    }

    public QueryOutputBuilder() {
        this(new TimeDisplayConfig("d", "h", "m", "s", "(<time> ago)"));
    }

    public QueryOutputBuilder append(@NonNull QueryResult res) {
        //caxerx used scroll_jj in world:x,y,z (10h ago)
        //(1337h ago) (20s ago) (3m ago)
        layout.append(res.getPlayerName()).color(ChatColor.GOLD).append(" used ").reset().append(res.getScrollName())
                .color(ChatColor.GOLD).append(" in ").reset().append(res.getWorld()).append(":")
                .append(String.valueOf(res.getX())).append(",").append(String.valueOf(res.getY()))
                .append(",").append(String.valueOf(res.getZ()))
                .append(" ").append(timeDisplayConfig.getFormattedTimeAgo(System.currentTimeMillis() - res.getTime())).color(ChatColor.GRAY).italic(true).append("\n").reset();
        return this;
    }


    public TextComponent build() {
        return new TextComponent(layout.create());
    }

}
