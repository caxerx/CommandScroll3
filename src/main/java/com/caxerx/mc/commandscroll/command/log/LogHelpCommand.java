package com.caxerx.mc.commandscroll.command.log;

import com.caxerx.mc.commandscroll.command.CommandNode;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ComponentBuilder;
import org.bukkit.command.CommandSender;

import java.util.List;

public class LogHelpCommand extends CommandNode {
    public LogHelpCommand(CommandNode parent) {
        super(parent,"help", "commandscroll.log", "Check the usage of condition query", null);
        addAlias("h");
        /*
        registerCondition(new EqualDatabaseCondition("w", "world"));
        registerCondition(new EqualDatabaseCondition("p", "player_name"));
        registerCondition(new EqualDatabaseCondition("u", "player_uuid"));
        registerCondition(new EqualDatabaseCondition("s", "scroll_name"));
        registerCondition(new TimeDatabaseCondition());
        registerCondition(new RangeDatabaseCondition());
         */
    }

    @Override
    public boolean executeCommand(CommandSender sender, List<String> args) {
        ComponentBuilder cpb = new ComponentBuilder("===== ").append("Condition Log Query Help").color(ChatColor.AQUA).append(" =====").color(ChatColor.RESET).append("\n");
        cpb.append("w:<world_name>").reset().append(" - ").color(ChatColor.GOLD).append("Specify the world name\n").color(ChatColor.YELLOW);
        cpb.append("p:<player_name>").reset().append(" - ").color(ChatColor.GOLD).append("Specify user's name\n").color(ChatColor.YELLOW);
        cpb.append("u:<player_uuid>").reset().append(" - ").color(ChatColor.GOLD).append("Specify user's uuid\n").color(ChatColor.YELLOW);
        cpb.append("s:<scroll_name>").reset().append(" - ").color(ChatColor.GOLD).append("Specify the scroll name\n").color(ChatColor.YELLOW);
        cpb.append("r:<range>").reset().append(" - ").color(ChatColor.GOLD).append("Specify use range, base on your location\n").color(ChatColor.YELLOW);
        cpb.append("t:<time_text>").reset().append(" - ").color(ChatColor.GOLD).append("Specify the use time\n").color(ChatColor.YELLOW);
        cpb.append("Example of time text:\n").color(ChatColor.AQUA);
        cpb.append("1d").color(ChatColor.RED).append("2h").color(ChatColor.GOLD).append("3m").color(ChatColor.GREEN).append("4s").color(ChatColor.LIGHT_PURPLE)
                .append(" - ").color(ChatColor.GOLD).append("1day").color(ChatColor.RED).append(", ").reset()
                .append("2hours").color(ChatColor.GOLD).append(", ").reset()
                .append("3minutes").color(ChatColor.GREEN).append(" and ").reset()
                .append("4seconds\n").color(ChatColor.LIGHT_PURPLE);
        cpb.append("4d").color(ChatColor.RED).append("30m").color(ChatColor.GREEN).append("7s").color(ChatColor.LIGHT_PURPLE)
                .append(" - ").color(ChatColor.GOLD).append("4days").color(ChatColor.RED).append(", ").reset()
                .append("30minutes").color(ChatColor.GREEN).append(" and ").reset()
                .append("7seconds\n").color(ChatColor.LIGHT_PURPLE);
        cpb.append("144h").color(ChatColor.GOLD).append(" - ").color(ChatColor.GOLD).append("144hours").color(ChatColor.GOLD);
        sender.spigot().sendMessage(cpb.create());
        return true;
    }

    @Override
    public List<String> executeTabCompletion(CommandSender sender, List<String> args) {
        return null;
    }
}
