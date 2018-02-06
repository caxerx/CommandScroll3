package com.caxerx.mc.commandscroll.command.display;

import com.caxerx.mc.commandscroll.scroll.Scroll;
import com.caxerx.mc.commandscroll.scroll.command.PermissionCommand;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ComponentBuilder;

public class ScrollInfoBuilder {
    private Scroll scroll;
    ComponentBuilder builder = new ComponentBuilder("");

    public ScrollInfoBuilder(Scroll scroll) {
        this.scroll = scroll;
        builder.append("=== Info of Scroll - ").color(ChatColor.WHITE).append(scroll.getName()).color(ChatColor.YELLOW).append(" ===\n").color(ChatColor.WHITE);
    }

    public ScrollInfoBuilder(Scroll scroll, boolean selected) {
        this.scroll = scroll;
        builder.append("=== Info of selected Scroll ===");
    }

    public BaseComponent[] getInfo() {
        // Info of Scroll - <name>
        // Commands:
        // Admin Command: /shit fuck my life <pf>
        // Permission Command: /shit cut game
        // + perm.ission
        // + mission.setfi
        builder.append("\n Commands:").color(ChatColor.WHITE);
        //AQUA = admin, GREEN = player, PURPLE = console, perm = RED
        scroll.getCommands().forEach(cmd -> {
            switch (cmd.getType()) {
                case ADMIN:
                    builder.append("- Admin Command: ").color(ChatColor.AQUA).append(cmd.getCommand()).color(ChatColor.WHITE).append("\n");
                    break;
                case CONSOLE:
                    builder.append("- Console Command: ").color(ChatColor.LIGHT_PURPLE).append(cmd.getCommand()).color(ChatColor.WHITE);
                    break;
                case PERMISSION:
                    builder.append("- Permission Command: ").color(ChatColor.RED).append(cmd.getCommand()).color(ChatColor.WHITE);
                    builder.append("\n");
                    ((PermissionCommand) cmd).getPermission().forEach(perm -> {
                        builder.append("    + ").color(ChatColor.GRAY).italic(true).append(perm).color(ChatColor.GRAY).italic(true).append("\n");
                    });
                    break;
                case PLAYER:
                default:
                    builder.append("- Player Command: ").color(ChatColor.GREEN).append(cmd.getCommand()).color(ChatColor.WHITE).append("\n");
            }
        });
        return builder.create();
    }
}
