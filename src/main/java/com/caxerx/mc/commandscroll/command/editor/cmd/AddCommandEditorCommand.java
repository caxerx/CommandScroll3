package com.caxerx.mc.commandscroll.command.editor.cmd;

import com.caxerx.mc.commandscroll.command.CommandArgumentException;
import com.caxerx.mc.commandscroll.command.CommandNode;
import com.caxerx.mc.commandscroll.command.CommandSelectManager;
import com.caxerx.mc.commandscroll.command.ScrollNotSelectedException;
import com.caxerx.mc.commandscroll.scroll.Scroll;
import com.caxerx.mc.commandscroll.scroll.command.CommandBuilder;
import com.caxerx.mc.commandscroll.scroll.command.ExecutableCommand;
import org.bukkit.command.CommandSender;

import java.util.List;

public class AddCommandEditorCommand extends CommandNode {
    private CommandSelectManager commandSelectManager;

    public AddCommandEditorCommand(CommandNode parent) {
        super(parent, "ac", "commandscroll.edit", "Add a command to selected scroll", "<command>");
        addAlias("add");
        addAlias("addcommand");
        commandSelectManager = CommandSelectManager.getInstance();
    }

    @Override
    public boolean executeCommand(CommandSender sender, List<String> args) {
        if (args.size() == 0) {
            throw new CommandArgumentException("cmd");
        }
        if (commandSelectManager.isSelectedScroll(sender)) {
            ExecutableCommand command = new CommandBuilder().player().set(String.join(" ", args)).build();
            Scroll scroll = commandSelectManager.getSelectedScroll(sender);
            int index = scroll.getCommands().size();
            scroll.addCommand(command);
            commandSelectManager.selectCommand(sender, index);
            sender.sendMessage("Command added to " + scroll.getName());
        } else {
            throw new ScrollNotSelectedException();
        }
        return true;
    }

    @Override
    public List<String> executeTabCompletion(CommandSender sender, List<String> args) {
        return null;
    }
}
