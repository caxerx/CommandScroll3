package com.caxerx.mc.commandscroll.scroll;

import lombok.NonNull;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class PermissionManager {
    private static PermissionManager instance = null;
    private Permission vaultPermissionController;

    public PermissionManager(@NonNull Permission vaultPermissionController) {
        this.vaultPermissionController = vaultPermissionController;
        instance = this;
    }

    public static PermissionManager getInstance() {
        return instance;
    }

    public List<String> addForbidden(@NonNull Player player,@NonNull List<String> permissions) {
        ArrayList<String> grantedPermission = new ArrayList<>();
        permissions.forEach(perm -> {
            if (addIfForbidden(player, perm)) {
                grantedPermission.add(perm);
            }
        });
        return grantedPermission;
    }

    public void removeGranted(@NonNull Player player, @NonNull List<String> permissions) {
        permissions.forEach(perm -> vaultPermissionController.playerRemove(player, perm));
    }

    public void remove(@NonNull Player player, @NonNull String permission) {
        vaultPermissionController.playerRemove(player, permission);
    }

    public boolean addIfForbidden(@NonNull Player player, @NonNull String permission) {
        if (vaultPermissionController.playerHas(player, permission)) {
            return false;
        }
        vaultPermissionController.playerAdd(player, permission);
        return true;
    }
}


