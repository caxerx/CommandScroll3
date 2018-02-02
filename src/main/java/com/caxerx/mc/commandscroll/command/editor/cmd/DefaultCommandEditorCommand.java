package com.caxerx.mc.commandscroll.command.editor.cmd;

import com.caxerx.mc.commandscroll.command.CommandNode;
import com.caxerx.mc.commandscroll.command.display.HelpOutputBuilder;
import org.bukkit.command.CommandSender;

import java.util.List;

public class DefaultCommandEditorCommand extends CommandNode {

    public DefaultCommandEditorCommand() {
        super("cse cmd", "commandscroll.edit", "Editing the commands in scroll", null);
        addAlias("cmd");
        addSub(new SelectCommandEditorCommand());
        addSub(new SetCommandTypeEditorCommand());
        addSub(new CommandAddPermissionEditorCommand());
        addSub(new AddCommandEditorCommand());
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
