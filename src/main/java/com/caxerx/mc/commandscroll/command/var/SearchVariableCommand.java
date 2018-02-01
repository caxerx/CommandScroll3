package com.caxerx.mc.commandscroll.command.var;

import com.caxerx.mc.commandscroll.command.CommandArgumentException;
import com.caxerx.mc.commandscroll.command.CommandNode;
import com.caxerx.mc.commandscroll.placeholder.VariableManager;
import org.bukkit.command.CommandSender;

import java.util.List;

public class SearchVariableCommand extends CommandNode {
    private VariableManager variableManager;

    public SearchVariableCommand() {
        super("search", "commandscroll.variable");
        variableManager = VariableManager.getInstance();
    }

    @Override
    public boolean executeCommand(CommandSender sender, List<String> args) {
        if (args.size() == 0) {
            throw new CommandArgumentException("keyword");
        }
        variableManager.searchVariable(args.get(0)).forEach(res -> {
            sender.sendMessage(res + ": " + variableManager.get(res));
        });
        return true;
    }

    @Override
    public List<String> executeTabCompletion(CommandSender sender, List<String> args) {
        return null;
    }
}
