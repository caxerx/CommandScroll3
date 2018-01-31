package com.caxerx.mc.commandscroll.scroll;

import lombok.AccessLevel;
import lombok.Setter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class PermissionCommand extends Command {
    @Setter(AccessLevel.PROTECTED)
    List<String> permission = new ArrayList<>();

    protected PermissionCommand() {
        super(CommandType.PERMISSION);
    }

    protected void addPermission(String perm) {
        permission.add(perm);
    }

    @Override
    public void execute(Player player) {
        PermissionManager permManager = PermissionManager.getInstance();
        List<String> granted = permManager.addForbidden(player, permission);
        player.performCommand(command);
        permManager.removeGranted(player, granted);
    }
}
