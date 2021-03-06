package com.caxerx.mc.commandscroll.command.editor.cmd;

import com.caxerx.mc.commandscroll.command.CommandNode;
import com.caxerx.mc.commandscroll.command.DefaultCommand;

public class DefaultCommandEditorCommand extends DefaultCommand {

    public DefaultCommandEditorCommand(CommandNode parent) {
        super(parent, "cmd", "commandscroll.edit", "Editing the commands in scroll", null);
        addAlias("command");
        addSub(new SelectCommandEditorCommand(this));
        addSub(new SetCommandTypeEditorCommand(this));
        addSub(new CommandAddPermissionEditorCommand(this));
        addSub(new AddCommandEditorCommand(this));
    }

}
