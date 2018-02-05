package com.caxerx.mc.commandscroll.command.log;

import com.caxerx.mc.commandscroll.command.CommandNode;
import com.caxerx.mc.commandscroll.command.display.QueryOutputBuilder;
import com.caxerx.mc.commandscroll.command.display.TimeDisplayConfig;
import com.caxerx.mc.commandscroll.logging.DatabaseController;
import com.caxerx.mc.commandscroll.logging.query.QueryResult;
import com.caxerx.mc.commandscroll.logging.query.condition.ConditionParser;
import com.google.common.collect.Lists;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class LogQueryCommand extends CommandNode {
    private DatabaseController databaseController;

    public LogQueryCommand(CommandNode parent) {
        super(parent, "q", "commandscroll.log", "Check the scroll usage log", "<condition>...");
        addAlias("query");
        databaseController = DatabaseController.getInstance();
    }

    @Override
    public boolean executeCommand(CommandSender sender, List<String> args) {
        Player player = (Player) sender;
        String sql = ConditionParser.getInstance().toSql(args, player);
        List<QueryResult> res = databaseController.queryLog(sql);
        QueryOutputBuilder qob = new QueryOutputBuilder(new TimeDisplayConfig("d", "h", "m", "s", "(<time> ago)"));
        res.forEach(qob::append);
        player.spigot().sendMessage(qob.build());
        return true;
    }

    @Override
    public List<String> executeTabCompletion(CommandSender sender, List<String> args) {
        if (args.get(args.size() - 1).startsWith("p:")) {
            List<String> playerls = new ArrayList<>();
            Bukkit.getOnlinePlayers().forEach(p -> playerls.add("p:" + p.getName()));
            return playerls;
        }
        return Lists.newArrayList("w:", "p:", "u:", "s:", "r:", "t:");
    }
}
