package com.caxerx.mc.commandscroll.command.editor;

import com.caxerx.mc.commandscroll.command.CommandArgumentException;
import com.caxerx.mc.commandscroll.command.CommandNode;
import com.caxerx.mc.commandscroll.command.CommandSelectManager;
import com.caxerx.mc.commandscroll.scroll.Scroll;
import com.caxerx.mc.commandscroll.scroll.ScrollManager;
import org.bukkit.command.CommandSender;

import java.util.List;

public class CreateEditorCommand extends CommandNode {
    public CreateEditorCommand(CommandNode parent) {
        super(parent, "create", "commandscroll.edit", "Create and select a scroll", "<scroll_name>");
        addAlias("add");
    }

    @Override
    public boolean executeCommand(CommandSender sender, List<String> args) {
        if (args.size() == 0) {
            throw new CommandArgumentException("scroll name");
        }
        Scroll scroll = new Scroll(args.get(0));
        ScrollManager.getInstance().addScroll(scroll);
        CommandSelectManager.getInstance().selectScroll(sender, args.get(0));
        sender.sendMessage("Scroll " + scroll.getName() + " is created and selected");
        return true;
    }

    @Override
    public List<String> executeTabCompletion(CommandSender sender, List<String> args) {
        return null;
    }
}
