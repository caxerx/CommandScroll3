package com.caxerx.mc.commandscroll.scroll.command;

import lombok.NonNull;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ConsoleCommand extends ExecutableCommand {
    protected ConsoleCommand() {
        super(CommandType.CONSOLE);
    }

    @Override
    public void execute(@NonNull Player player) {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
    }
}
