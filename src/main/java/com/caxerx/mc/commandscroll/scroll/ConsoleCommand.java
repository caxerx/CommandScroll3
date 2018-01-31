package com.caxerx.mc.commandscroll.scroll;

import lombok.Data;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

@Data
public class ConsoleCommand extends Command {
    protected ConsoleCommand() {
        super(CommandType.CONSOLE);
    }

    @Override
    public void execute(Player player) {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
    }
}
