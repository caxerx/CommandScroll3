package com.caxerx.mc.commandscroll.command.var;

import com.caxerx.mc.commandscroll.command.DefaultCommand;

public class DefaultVariableCommand extends DefaultCommand {
    public DefaultVariableCommand() {
        super(null,"csv", "commandscroll.variable", "Default command of variable", null);
        addAlias("csvar");
        addAlias("commandscrollvariable");
        addSub(new GetVariableCommand(this));
        addSub(new ListVariableCommand(this));
        addSub(new SearchVariableCommand(this));
        addSub(new SetVariableCommand(this));
    }

}
