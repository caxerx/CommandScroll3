package com.caxerx.mc.commandscroll.scroll;

import net.milkbowl.vault.permission.Permission;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class PermissionManager {
    private static PermissionManager instance = null;
    private Permission vaultPermissionController;

    private PermissionManager(Permission vaultPermissionController) {
        this.vaultPermissionController = vaultPermissionController;
        instance = this;
    }

    public static PermissionManager getInstance() {
        return instance;
    }

    public List<String> addForbidden(Player player, List<String> permissions) {
        ArrayList<String> grantedPermission = new ArrayList<>();
        permissions.forEach(perm -> {
            if (addIfForbidden(player, perm)) {
                grantedPermission.add(perm);
            }
        });
        return grantedPermission;
    }

    public void removeGranted(Player player, List<String> permissions) {
        permissions.forEach(perm -> vaultPermissionController.playerRemove(player, perm));
    }

    public void remove(Player player, String permission) {
        vaultPermissionController.playerRemove(player, permission);
    }

    public boolean addIfForbidden(Player player, String permission) {
        if (vaultPermissionController.playerHas(player, permission)) {
            return false;
        }
        vaultPermissionController.playerAdd(player, permission);
        return true;
    }
}


