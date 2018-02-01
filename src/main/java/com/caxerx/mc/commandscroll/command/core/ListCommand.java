package com.caxerx.mc.commandscroll.command.core;

import com.caxerx.mc.commandscroll.command.CommandNode;
import com.caxerx.mc.commandscroll.scroll.ScrollManager;
import org.bukkit.command.CommandSender;

import java.util.List;

public class ListCommand extends CommandNode {
    private ScrollManager scrollManager;

    public ListCommand() {
        super("list", "commandscroll.list");
        scrollManager = ScrollManager.getInstance();
        addAlias("ls");
    }

    @Override
    public boolean executeCommand(CommandSender sender, List<String> args) {
        scrollManager.getAllScroll().keySet().forEach(sender::sendMessage);
        return true;
    }

    @Override
    public List<String> executeTabCompletion(CommandSender sender, List<String> args) {
        return null;
    }
}
