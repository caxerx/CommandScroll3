package com.caxerx.mc.commandscroll.command.var;

import com.caxerx.mc.commandscroll.command.CommandNode;
import com.caxerx.mc.commandscroll.command.display.HelpOutputBuilder;
import org.bukkit.command.CommandSender;

import java.util.List;

public class DefaultVariableCommand extends CommandNode {
    public DefaultVariableCommand() {
        super("csv", "commandscroll.variable", "Default command of variable", null);
        addAlias("csvar");
        addAlias("commandscrollvariable");
        addSub(new GetVariableCommand());
        addSub(new ListVariableCommand());
        addSub(new SearchVariableCommand());
        addSub(new SetVariableCommand());
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
        return null;
    }
}
