package com.caxerx.mc.commandscroll.command.core;

import com.caxerx.mc.commandscroll.command.DefaultCommand;

public class DefaultCoreCommand extends DefaultCommand {
    public DefaultCoreCommand() {
        super(null, "cs", null, "Main command of Command Scroll", null);
        addAlias("commandscroll");
        addSub(new ListCommand(this));
        addSub(new InfoCommand(this));
    }
}
