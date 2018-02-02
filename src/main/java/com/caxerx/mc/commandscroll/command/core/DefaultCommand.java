package com.caxerx.mc.commandscroll.command.core;

import com.caxerx.mc.commandscroll.command.CommandNode;
import com.caxerx.mc.commandscroll.command.display.HelpOutputBuilder;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;

public class DefaultCommand extends CommandNode {
    public DefaultCommand() {
        super("cs", null, "Main command of Command Scroll", null);
        addAlias("commandscroll");
        addSub(new ListCommand());
        addSub(new InfoCommand());
    }

    @Override
    public boolean executeCommand(CommandSender sender, List<String> args) {
        HelpOutputBuilder builder = new HelpOutputBuilder(this);
        getSubCommands().forEach(sub -> {
            builder.append(sub);
        });
        sender.spigot().sendMessage(builder.build());
        return true;
    }

    @Override
    public List<String> executeTabCompletion(CommandSender sender, List<String> args) {
        ArrayList<String> result = new ArrayList<>();
        getSubCommands().forEach(sub -> result.add(sub.getAlias().get(0)));
        return result;
    }
}
