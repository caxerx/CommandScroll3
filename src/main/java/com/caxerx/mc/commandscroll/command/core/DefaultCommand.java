package com.caxerx.mc.commandscroll.command.core;

import com.caxerx.mc.commandscroll.command.CommandNode;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;

public class DefaultCommand extends CommandNode {
    public DefaultCommand() {
        super("commandscroll", null);
        addAlias("cs");
        addSub(new ListCommand());
        addSub(new InfoCommand());
    }

    @Override
    public boolean executeCommand(CommandSender sender, List<String> args) {
        sender.sendMessage("cs main cmd");
        return true;
    }

    @Override
    public List<String> executeTabCompletion(CommandSender sender, List<String> args) {
        ArrayList<String> result = new ArrayList<>();
        getSubCommands().forEach(sub -> result.add(sub.getAlias().get(0)));
        return result;
    }
}
