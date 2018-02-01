package com.caxerx.mc.commandscroll.command.editor;

import com.caxerx.mc.commandscroll.command.CommandNode;
import com.caxerx.mc.commandscroll.command.CommandSelectManager;
import com.caxerx.mc.commandscroll.scroll.Scroll;
import com.caxerx.mc.commandscroll.scroll.ScrollManager;
import org.bukkit.command.CommandSender;

import java.util.List;

public class InfoEditorCommand extends CommandNode {
    private ScrollManager scrollManager;
    private CommandSelectManager commandSelectManager;

    public InfoEditorCommand() {
        super("info", "commandscroll.edit");
        scrollManager = ScrollManager.getInstance();
        commandSelectManager = CommandSelectManager.getInstance();
    }

    @Override
    public boolean executeCommand(CommandSender sender, List<String> args) {
        if (commandSelectManager.isSelectedScroll(sender)) {
            Scroll scroll = commandSelectManager.getSelectedScroll(sender);
            sender.sendMessage("selected " + scroll.getName());
            scroll.getCommands().forEach(cmd -> {
                sender.sendMessage(cmd.getType() + " " + cmd.getCommand());
            });
        } else {
            sender.sendMessage("not selected");
        }

        return true;
    }

    @Override
    public List<String> executeTabCompletion(CommandSender sender, List<String> args) {
        return null;
    }
}
