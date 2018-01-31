package com.caxerx.mc.commandscroll.scroll;

import org.bukkit.entity.Player;

public class AdminCommand extends Command {
    protected AdminCommand() {
        super(CommandType.ADMIN);
    }

    @Override
    public void execute(Player player) {
        PermissionManager permManager = PermissionManager.getInstance();
        boolean granted = permManager.addIfForbidden(player, "*");
        player.performCommand(command);
        if (granted) {
            permManager.remove(player, "*");
        }
    }
}
