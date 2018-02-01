package com.caxerx.mc.commandscroll.command.log;

import com.caxerx.mc.commandscroll.command.CommandNode;
import com.caxerx.mc.commandscroll.command.display.QueryOutputBuilder;
import com.caxerx.mc.commandscroll.command.display.TimeDisplayConfig;
import com.caxerx.mc.commandscroll.logging.DatabaseController;
import com.caxerx.mc.commandscroll.logging.query.QueryResult;
import com.caxerx.mc.commandscroll.logging.query.condition.ConditionParser;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class DefaultLogCommand extends CommandNode {
    DatabaseController databaseController;

    public DefaultLogCommand() {
        super("cslog", "commandscroll.log");
        databaseController = DatabaseController.getInstance();
    }

    @Override
    public boolean executeCommand(CommandSender sender, List<String> args) {
        Player player = (Player) sender;
        String sql = ConditionParser.getInstance().toSql(args, player);
        List<QueryResult> res = databaseController.queryLog(sql);
        QueryOutputBuilder qob = new QueryOutputBuilder(new TimeDisplayConfig("d", "h", "m", "s", "(<time> ago)"));
        res.forEach(qr -> {
            qob.append(qr);
        });
        player.spigot().sendMessage(qob.build());
        return true;
    }

    @Override
    public List<String> executeTabCompletion(CommandSender sender, List<String> args) {
        return null;
    }
}
