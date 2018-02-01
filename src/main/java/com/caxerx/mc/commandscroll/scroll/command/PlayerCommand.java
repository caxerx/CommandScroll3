package com.caxerx.mc.commandscroll.scroll.command;

import lombok.NonNull;
import org.bukkit.entity.Player;

public class PlayerCommand extends ExecutableCommand {
    protected PlayerCommand() {
        super(CommandType.PLAYER);
    }

    @Override
    public void execute(@NonNull Player player) {
        player.performCommand(command);
    }
}
