package com.caxerx.mc.commandscroll.logging.log;

import com.caxerx.mc.commandscroll.logging.DatabaseController;
import com.caxerx.mc.commandscroll.scroll.Scroll;
import lombok.NonNull;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.io.File;

public class ScrollLogger {
    private static ScrollLogger instance;
    private DatabaseController controller;

    public ScrollLogger(@NonNull File databaseFile) {
        controller = new DatabaseController(databaseFile);
        instance = this;
    }

    public static ScrollLogger getInstance() {
        return instance;
    }

    public void log(@NonNull Player player, @NonNull Scroll scroll) {
        String playerName = player.getName();
        String playerUuid = player.getUniqueId().toString();
        Location playerLocation = player.getLocation();
        String scrollName = scroll.getName();
        String playerWorld = playerLocation.getWorld().getName();
        int playerLocationX = (int) playerLocation.getX();
        int playerLocationY = (int) playerLocation.getY();
        int playerLocationZ = (int) playerLocation.getZ();
        controller.addLog(playerName, playerUuid, scrollName, System.currentTimeMillis(), playerWorld, playerLocationX, playerLocationY, playerLocationZ);
    }
}
