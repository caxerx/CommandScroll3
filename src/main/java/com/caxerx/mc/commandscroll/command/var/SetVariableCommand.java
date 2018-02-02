package com.caxerx.mc.commandscroll.command.var;

import com.caxerx.mc.commandscroll.command.CommandArgumentException;
import com.caxerx.mc.commandscroll.command.CommandNode;
import com.caxerx.mc.commandscroll.placeholder.VariableManager;
import org.bukkit.command.CommandSender;

import java.util.List;

public class SetVariableCommand extends CommandNode {
    VariableManager variableManager;

    public SetVariableCommand() {
        super("set", "commandscroll.variable","Set the value of a variable","<variable>");
        variableManager = VariableManager.getInstance();
    }

    @Override
    public boolean executeCommand(CommandSender sender, List<String> args) {
        if (args.size() < 2) {
            throw new CommandArgumentException("size");
        }
        variableManager.put(args.get(0), args.get(1));
        sender.sendMessage("setted");
        return true;
    }

    @Override
    public List<String> executeTabCompletion(CommandSender sender, List<String> args) {
        return null;
    }
}
