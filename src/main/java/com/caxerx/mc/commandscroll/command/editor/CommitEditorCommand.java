package com.caxerx.mc.commandscroll.command.editor;

import com.caxerx.mc.commandscroll.command.CommandNode;
import com.caxerx.mc.commandscroll.command.CommandSelectManager;
import com.caxerx.mc.commandscroll.scroll.Scroll;
import com.caxerx.mc.commandscroll.scroll.ScrollManager;
import org.bukkit.command.CommandSender;

import java.util.List;

public class CommitEditorCommand extends CommandNode {
    private CommandSelectManager commandSelectManager;
    private ScrollManager scrollManager;

    public CommitEditorCommand(CommandNode parent) {
        super(parent, "apply", "commandscroll.edit", "Apply the edit of the scroll", null);
        addAlias("commit");
        commandSelectManager = CommandSelectManager.getInstance();
        scrollManager = ScrollManager.getInstance();
    }

    @Override
    public boolean executeCommand(CommandSender sender, List<String> args) {
        if (commandSelectManager.isSelectedScroll(sender)) {
            Scroll scroll = commandSelectManager.getSelectedScroll(sender);
            commandSelectManager.commitEdit(sender);
            sender.sendMessage("commited");
        }
        return true;
    }

    @Override
    public List<String> executeTabCompletion(CommandSender sender, List<String> args) {
        return null;
    }
}
