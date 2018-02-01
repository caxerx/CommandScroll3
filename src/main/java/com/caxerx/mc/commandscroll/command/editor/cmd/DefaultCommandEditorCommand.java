package com.caxerx.mc.commandscroll.command.editor.cmd;

import com.caxerx.mc.commandscroll.command.CommandNode;
import org.bukkit.command.CommandSender;

import java.util.List;

public class DefaultCommandEditorCommand extends CommandNode {

    public DefaultCommandEditorCommand() {
        super("cmd", "commandscroll.edit");
        addSub(new SelectCommandEditorCommand());
        addSub(new SetCommandTypeEditorCommand());
        addSub(new CommandAddPermissionEditorCommand());
        addSub(new AddCommandEditorCommand());
    }

    @Override
    public boolean executeCommand(CommandSender sender, List<String> args) {
        return false;
    }

    @Override
    public List<String> executeTabCompletion(CommandSender sender, List<String> args) {
        return null;
    }
}
