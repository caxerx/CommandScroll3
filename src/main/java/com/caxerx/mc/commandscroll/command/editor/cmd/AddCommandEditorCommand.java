package com.caxerx.mc.commandscroll.command.editor.cmd;

import com.caxerx.mc.commandscroll.command.CommandArgumentException;
import com.caxerx.mc.commandscroll.command.CommandNode;
import com.caxerx.mc.commandscroll.command.CommandSelectManager;
import com.caxerx.mc.commandscroll.scroll.Scroll;
import com.caxerx.mc.commandscroll.scroll.command.CommandBuilder;
import com.caxerx.mc.commandscroll.scroll.command.ExecutableCommand;
import org.bukkit.command.CommandSender;

import java.util.List;

public class AddCommandEditorCommand extends CommandNode {
    private CommandSelectManager commandSelectManager;

    public AddCommandEditorCommand() {
        super("ac", "commandscroll.edit", "Add a command to selected scroll", "<command>");
        addAlias("add");
        commandSelectManager = CommandSelectManager.getInstance();
    }

    @Override
    public boolean executeCommand(CommandSender sender, List<String> args) {
        if (args.size() == 0) {
            throw new CommandArgumentException("perm");
        }
        if (commandSelectManager.isSelectedScroll(sender)) {
            ExecutableCommand command = new CommandBuilder().player().set(String.join(" ", args)).build();
            Scroll scroll = commandSelectManager.getSelectedScroll(sender);
            int index = scroll.getCommands().size();
            scroll.addCommand(command);
            commandSelectManager.selectCommand(sender, index);
            sender.sendMessage("added command to " + scroll.getName());
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
