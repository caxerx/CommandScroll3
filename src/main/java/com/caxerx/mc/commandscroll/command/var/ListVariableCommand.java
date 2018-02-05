package com.caxerx.mc.commandscroll.command.var;

import com.caxerx.mc.commandscroll.command.CommandNode;
import com.caxerx.mc.commandscroll.placeholder.VariableManager;
import org.bukkit.command.CommandSender;

import java.util.List;

public class ListVariableCommand extends CommandNode {
    VariableManager variableManager;

    public ListVariableCommand(CommandNode parent) {
        super(parent, "ls", "commandscroll.variable", "List all variable", null);
        addAlias("list");
        variableManager = VariableManager.getInstance();
    }

    @Override
    public boolean executeCommand(CommandSender sender, List<String> args) {
        variableManager.getVariableMap().forEach((key, val) -> sender.sendMessage(key + ": " + val));
        return true;
    }

    @Override
    public List<String> executeTabCompletion(CommandSender sender, List<String> args) {
        return null;
    }
}
