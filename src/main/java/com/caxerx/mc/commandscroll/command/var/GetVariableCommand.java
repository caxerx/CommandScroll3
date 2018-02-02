package com.caxerx.mc.commandscroll.command.var;

import com.caxerx.mc.commandscroll.command.CommandArgumentException;
import com.caxerx.mc.commandscroll.command.CommandNode;
import com.caxerx.mc.commandscroll.placeholder.VariableManager;
import org.bukkit.command.CommandSender;

import java.util.List;

public class GetVariableCommand extends CommandNode {
    private VariableManager variableManager;

    public GetVariableCommand() {
        super("get", "commandscroll.variable", "Get the value of a variable", "<variable>");
        variableManager = VariableManager.getInstance();
    }

    @Override
    public boolean executeCommand(CommandSender sender, List<String> args) {
        if (args.size() == 0) {
            throw new CommandArgumentException("var name");
        }
        String res = variableManager.get(args.get(0));
        if (res != null) {
            sender.sendMessage(args.get(0) + " = " + res);
        } else {
            sender.sendMessage(args.get(0) + " not found");
        }
        return true;
    }

    @Override
    public List<String> executeTabCompletion(CommandSender sender, List<String> args) {
        return null;
    }
}
