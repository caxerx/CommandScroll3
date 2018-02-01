package com.caxerx.mc.commandscroll.command.editor;

import com.caxerx.mc.commandscroll.command.CommandNode;
import org.bukkit.command.CommandSender;

import java.util.List;

public class DefaultEditorCommand extends CommandNode {
    public DefaultEditorCommand() {
        super("commandscrolleditor", "commandscroll.edit");
        addAlias("cse");
        addSub(new SelectEditorCommand());
        addSub(new AddEditorCommand());

    }

    @Override
    public boolean executeCommand(CommandSender sender, List<String> args) {
        sender.sendMessage("default edit command");
        return true;
    }

    @Override
    public List<String> executeTabCompletion(CommandSender sender, List<String> args) {
        return null;
    }
}
