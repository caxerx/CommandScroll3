package com.caxerx.mc.commandscroll.command.editor.cmd;

import com.caxerx.mc.commandscroll.command.CommandArgumentException;
import com.caxerx.mc.commandscroll.command.CommandNode;
import com.caxerx.mc.commandscroll.command.CommandSelectManager;
import com.caxerx.mc.commandscroll.scroll.command.PermissionCommand;
import org.bukkit.command.CommandSender;

import java.util.List;

public class CommandAddPermissionEditorCommand extends CommandNode {
    private CommandSelectManager commandSelectManager;

    public CommandAddPermissionEditorCommand() {
        super("addpermission", "commandscroll.edit");
        commandSelectManager = CommandSelectManager.getInstance();
        addAlias("ap");
    }

    @Override
    public boolean executeCommand(CommandSender sender, List<String> args) {
        if (args.size() == 0) {
            throw new CommandArgumentException("perm");
        }
        if (commandSelectManager.isSelectedScroll(sender)) {
            if (commandSelectManager.isSelectedCommand(sender)) {
                if (commandSelectManager.getSelectedCommand(sender) instanceof PermissionCommand) {
                    ((PermissionCommand) commandSelectManager.getSelectedCommand(sender)).addPermission(args.get(0));
                    sender.sendMessage("added perm");
                } else {
                    sender.sendMessage("not a perm cmd");
                }
            } else {
                sender.sendMessage("select command first");
            }
        } else {
            sender.sendMessage("select scroll first");
        }
        return true;
    }

    @Override
    public List<String> executeTabCompletion(CommandSender sender, List<String> args) {
        return null;
    }
}
