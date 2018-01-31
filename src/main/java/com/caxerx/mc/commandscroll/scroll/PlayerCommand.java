package com.caxerx.mc.commandscroll.scroll;

import org.bukkit.entity.Player;

public class PlayerCommand extends Command {
    protected PlayerCommand() {
        super(CommandType.PLAYER);
    }

    @Override
    public void execute(Player player) {
        player.performCommand(command);
    }
}
