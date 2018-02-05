package com.caxerx.mc.commandscroll.command.editor;

import com.caxerx.mc.commandscroll.command.DefaultCommand;
import com.caxerx.mc.commandscroll.command.editor.cmd.DefaultCommandEditorCommand;

public class DefaultEditorCommand extends DefaultCommand {
    public DefaultEditorCommand() {
        super(null, "cse", "commandscroll.edit", "Main command of Command Scroll Editor", null);
        addAlias("commandscrolleditor");
        addSub(new SelectEditorCommand(this));
        addSub(new CreateEditorCommand(this));
        addSub(new InfoEditorCommand(this));
        addSub(new CommitEditorCommand(this));
        addSub(new DefaultCommandEditorCommand(this));
    }

}
