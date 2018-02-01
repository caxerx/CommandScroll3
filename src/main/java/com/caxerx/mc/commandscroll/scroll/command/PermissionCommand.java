package com.caxerx.mc.commandscroll.scroll.command;

import com.caxerx.mc.commandscroll.scroll.PermissionManager;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.Setter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class PermissionCommand extends ExecutableCommand {
    @Setter(AccessLevel.PROTECTED)
    List<String> permission = new ArrayList<>();

    protected PermissionCommand() {
        super(CommandType.PERMISSION);
    }

    protected void addPermission(@NonNull String perm) {
        permission.add(perm);
    }

    @Override
    public void execute(@NonNull Player player) {
        PermissionManager permManager = PermissionManager.getInstance();
        List<String> granted = permManager.addForbidden(player, permission);
        player.performCommand(command);
        permManager.removeGranted(player, granted);
    }
}
