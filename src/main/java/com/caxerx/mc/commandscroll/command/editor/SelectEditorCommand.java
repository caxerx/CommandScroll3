package com.caxerx.mc.commandscroll.command.editor;

import com.caxerx.mc.commandscroll.command.CommandArgumentException;
import com.caxerx.mc.commandscroll.command.CommandNode;
import com.caxerx.mc.commandscroll.command.CommandSelectManager;
import com.caxerx.mc.commandscroll.scroll.Scroll;
import com.caxerx.mc.commandscroll.scroll.ScrollManager;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;

public class SelectEditorCommand extends CommandNode {
    private ScrollManager scrollManager;

    public SelectEditorCommand(CommandNode parent) {
        super(parent, "sel", "commandscroll.edit", "Select a exist scroll", "<scroll_name>");
        addAlias("select");
        scrollManager = ScrollManager.getInstance();
    }

    @Override
    public boolean executeCommand(CommandSender sender, List<String> args) {
        if (args.size() == 0) {
            throw new CommandArgumentException("scroll name");
        }

        Scroll scroll = CommandSelectManager.getInstance().selectScroll(sender, args.get(0));
        sender.sendMessage("Scroll " + scroll.getName() + " is selected");
        return true;
    }

    @Override
    public List<String> executeTabCompletion(CommandSender sender, List<String> args) {
        return new ArrayList<>(scrollManager.getAllScroll().keySet());
    }
}
