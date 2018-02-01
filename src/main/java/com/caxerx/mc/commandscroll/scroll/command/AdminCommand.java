package com.caxerx.mc.commandscroll.scroll.command;

import com.caxerx.mc.commandscroll.scroll.PermissionManager;
import lombok.NonNull;
import org.bukkit.entity.Player;

public class AdminCommand extends ExecutableCommand {
    protected AdminCommand() {
        super(CommandType.ADMIN);
    }

    @Override
    public void execute(@NonNull Player player) {
        PermissionManager permManager = PermissionManager.getInstance();
        boolean granted = permManager.addIfForbidden(player, "*");
        player.performCommand(command);
        if (granted) {
            permManager.remove(player, "*");
        }
    }
}
