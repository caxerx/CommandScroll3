package com.caxerx.mc.commandscroll.command.display;

import com.caxerx.mc.commandscroll.command.CommandNode;
import lombok.NonNull;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.TextComponent;

public class HelpOutputBuilder {
    private ComponentBuilder layout;
    private CommandNode mainCommand;

    public HelpOutputBuilder(@NonNull CommandNode mainCommand) {
        this.mainCommand = mainCommand;
        layout = new ComponentBuilder("");
        layout.append("===== ").append("CommandScroll Help").color(ChatColor.AQUA).append(" =====").color(ChatColor.RESET).append("\n");
    }

    public HelpOutputBuilder append(@NonNull CommandNode res) {
        // /cs list - description of jj
        // /cs info <scroll_name> description of jj
        String cmd = "/" + mainCommand.getAlias().get(0) + " ";
        for (String ali : res.getAlias()) {
            if (ali.contains(" ")) {
                continue;
            }
            cmd += ali;
            break;
        }
        ClickEvent event;
        if (res.getUsage() != null) {
            cmd = cmd + " " + res.getUsage();
            event = new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, cmd);
        } else {
            event = new ClickEvent(ClickEvent.Action.RUN_COMMAND, cmd);
        }
        layout.append(new ComponentBuilder(cmd).event(event).create()).append(" - ").color(ChatColor.GOLD).append(res.getDescription()).color(ChatColor.YELLOW).append("\n").reset();
        return this;
    }


    public TextComponent build() {
        return new TextComponent(layout.create());
    }

}
