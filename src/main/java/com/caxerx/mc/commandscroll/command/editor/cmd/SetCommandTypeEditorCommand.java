package com.caxerx.mc.commandscroll.command.editor.cmd;

import com.caxerx.mc.commandscroll.command.CommandNode;
import com.caxerx.mc.commandscroll.command.CommandNotSelectedException;
import com.caxerx.mc.commandscroll.command.CommandSelectManager;
import com.caxerx.mc.commandscroll.command.ScrollNotSelectedException;
import com.caxerx.mc.commandscroll.scroll.command.CommandBuilder;
import com.google.common.collect.Lists;
import org.bukkit.command.CommandSender;

import java.util.List;

public class SetCommandTypeEditorCommand extends CommandNode {
    private CommandSelectManager commandSelectManager;

    public SetCommandTypeEditorCommand(CommandNode parent) {
        super(parent, "st", "commandscroll.edit", "Set the command type of a scroll", "<type>");
        addAlias("settype");
        commandSelectManager = CommandSelectManager.getInstance();
    }

    @Override
    public boolean executeCommand(CommandSender sender, List<String> args) {
        if (commandSelectManager.isSelectedScroll(sender)) {
            if (commandSelectManager.isSelectedCommand(sender)) {
                CommandBuilder commandBuilder = new CommandBuilder();
                switch (args.get(0)) {
                    case "admin":
                        commandBuilder.admin();
                        break;
                    case "permission":
                        commandBuilder.permission();
                        break;
                    case "console":
                        commandBuilder.console();
                        break;
                    case "player":
                    default:
                        commandBuilder.player();
                }
                commandBuilder.set(commandSelectManager.getSelectedCommand(sender).getCommand());
                commandSelectManager.setSelectedCommand(sender, commandBuilder.build());
                sender.sendMessage("Command type has set to " + args.get(0));
            } else {
                throw new CommandNotSelectedException();
            }
        } else {
            throw new ScrollNotSelectedException();
        }
        return false;
    }

    @Override
    public List<String> executeTabCompletion(CommandSender sender, List<String> args) {
        return Lists.newArrayList("player", "admin", "console", "permission");
    }
}
