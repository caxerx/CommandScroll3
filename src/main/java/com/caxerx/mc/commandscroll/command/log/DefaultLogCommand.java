package com.caxerx.mc.commandscroll.command.log;

import com.caxerx.mc.commandscroll.command.DefaultCommand;

public class DefaultLogCommand extends DefaultCommand {
    public DefaultLogCommand() {
        super(null,"csl", "commandscroll.log", "Main Log Command", null);
        addAlias("cslog");
        addAlias("commandscrolllog");
        addSub(new LogHelpCommand(this));
        addSub(new LogQueryCommand(this));
    }
}
