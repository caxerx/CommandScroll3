package com.caxerx.mc.commandscroll.command.editor;

import com.caxerx.mc.commandscroll.command.CommandNode;
import com.caxerx.mc.commandscroll.command.display.HelpOutputBuilder;
import com.caxerx.mc.commandscroll.command.editor.cmd.DefaultCommandEditorCommand;
import org.bukkit.command.CommandSender;

import java.util.List;

public class DefaultEditorCommand extends CommandNode {
    public DefaultEditorCommand() {
        super("cse", "commandscroll.edit", "Main command of Command Scroll Editor", null);
        addAlias("commandscrolleditor");
        addSub(new SelectEditorCommand());
        addSub(new CreateEditorCommand());
        addSub(new InfoEditorCommand());
        addSub(new CommitEditorCommand());
        addSub(new DefaultCommandEditorCommand());
    }

    @Override
    public boolean executeCommand(CommandSender sender, List<String> args) {
        HelpOutputBuilder builder = new HelpOutputBuilder(this);
        getSubCommands().forEach(sub -> {
            builder.append(sub);
        });
        sender.spigot().sendMessage(builder.build());
        return true;
    }

    @Override
    public List<String> executeTabCompletion(CommandSender sender, List<String> args) {
        return null;
    }
}
