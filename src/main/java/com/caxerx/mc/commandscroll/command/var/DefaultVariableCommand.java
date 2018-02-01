package com.caxerx.mc.commandscroll.command.var;

import com.caxerx.mc.commandscroll.command.CommandNode;
import org.bukkit.command.CommandSender;

import java.util.List;

public class DefaultVariableCommand extends CommandNode {
    public DefaultVariableCommand() {
        super("commandscrollvariable", "commandscroll.variable");
        addAlias("csvar");
        addSub(new GetVariableCommand());
        addSub(new ListVariableCommand());
        addSub(new SearchVariableCommand());
        addSub(new SetVariableCommand());
    }

    @Override
    public boolean executeCommand(CommandSender sender, List<String> args) {
        sender.sendMessage("csvar default");
        return true;
    }

    @Override
    public List<String> executeTabCompletion(CommandSender sender, List<String> args) {
        return null;
    }
}
