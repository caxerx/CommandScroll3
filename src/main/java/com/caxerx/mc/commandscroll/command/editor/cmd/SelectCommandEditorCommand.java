package com.caxerx.mc.commandscroll.command.editor.cmd;

import com.caxerx.mc.commandscroll.command.CommandArgumentException;
import com.caxerx.mc.commandscroll.command.CommandNode;
import com.caxerx.mc.commandscroll.command.CommandSelectManager;
import com.caxerx.mc.commandscroll.scroll.Scroll;
import org.bukkit.command.CommandSender;

import java.util.List;

public class SelectCommandEditorCommand extends CommandNode {
    private CommandSelectManager commandSelectManager;

    public SelectCommandEditorCommand() {
        super("select", "commandscroll.edit");
        addAlias("sel");
        commandSelectManager = CommandSelectManager.getInstance();
    }

    @Override
    public boolean executeCommand(CommandSender sender, List<String> args) {
        if (args.size() == 0) {
            throw new CommandArgumentException("scroll");
        }
        if (commandSelectManager.isSelectedScroll(sender)) {
            int idx;
            try {
                idx = Integer.parseInt(args.get(0));
            } catch (Exception e) {
                throw new CommandArgumentException("integer");
            }
            Scroll scroll = commandSelectManager.getSelectedScroll(sender);
            commandSelectManager.selectCommand(sender, idx);
            sender.sendMessage("selected cmd");
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
