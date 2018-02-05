package com.caxerx.mc.commandscroll.command.core;

import com.caxerx.mc.commandscroll.command.CommandArgumentException;
import com.caxerx.mc.commandscroll.command.CommandNode;
import com.caxerx.mc.commandscroll.scroll.Scroll;
import com.caxerx.mc.commandscroll.scroll.ScrollManager;
import com.caxerx.mc.commandscroll.scroll.command.PermissionCommand;
import org.bukkit.command.CommandSender;

import java.util.List;

public class InfoCommand extends CommandNode {
    public InfoCommand(CommandNode parent) {
        super(parent, "info", "commandscroll.info", "Check the info of a scroll", "<scroll_name>");
    }

    @Override
    public boolean executeCommand(CommandSender sender, List<String> args) {
        if (args.size() == 0) {
            throw new CommandArgumentException("scroll name");
        }
        Scroll scroll = ScrollManager.getInstance().getScroll(args.get(0));
        sender.sendMessage("scroll: " + scroll.getName());
        scroll.getCommands().forEach(cmd -> {
            sender.sendMessage(cmd.getType() + " " + cmd.getCommand());
            if (cmd instanceof PermissionCommand) {
                ((PermissionCommand) cmd).getPermission().forEach(pem -> {
                    sender.sendMessage(" -" + pem);
                });
            }
        });
        return true;
    }

    @Override
    public List<String> executeTabCompletion(CommandSender sender, List<String> args) {
        return null;
    }
}
