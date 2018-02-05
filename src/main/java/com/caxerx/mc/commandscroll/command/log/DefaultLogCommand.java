package com.caxerx.mc.commandscroll.command.log;

import com.caxerx.mc.commandscroll.command.CommandNode;
import com.caxerx.mc.commandscroll.command.DefaultCommand;
import com.caxerx.mc.commandscroll.command.display.HelpOutputBuilder;
import com.caxerx.mc.commandscroll.command.display.QueryOutputBuilder;
import com.caxerx.mc.commandscroll.command.display.TimeDisplayConfig;
import com.caxerx.mc.commandscroll.logging.query.QueryResult;
import com.caxerx.mc.commandscroll.logging.query.condition.ConditionParser;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class DefaultLogCommand extends DefaultCommand {
    public DefaultLogCommand() {
        super(null,"csl", "commandscroll.log", "Main Log Command", null);
        addAlias("cslog");
        addAlias("commandscrolllog");
        addSub(new LogHelpCommand(this));
        addSub(new LogQueryCommand(this));
    }
}
