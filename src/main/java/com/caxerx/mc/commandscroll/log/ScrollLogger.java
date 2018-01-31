package com.caxerx.mc.commandscroll.log;

import com.caxerx.mc.commandscroll.scroll.Scroll;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.io.File;

public class ScrollLogger {
    private static final String DEFAULT_DATABASE_VALUE = "__UNKNOWN";
    private DatabaseController controller;

    public ScrollLogger(File databaseFile) {
        controller = new DatabaseController(databaseFile);
    }

    public void log(Player player, Scroll scroll) {
        String playerName;
        String playerUuid;
        String scrollName;
        String playerWorld;
        int playerLocationX;
        int playerLocationY;
        int playerLocationZ;
        if (player == null) {
            playerName = DEFAULT_DATABASE_VALUE;
            playerUuid = DEFAULT_DATABASE_VALUE;
            playerWorld = DEFAULT_DATABASE_VALUE;
            playerLocationX = -1;
            playerLocationY = -1;
            playerLocationZ = -1;
        } else {
            playerName = player.getName();
            playerUuid = player.getUniqueId().toString();
            Location playerLocation = player.getLocation();
            playerWorld = playerLocation.getWorld().getName();
            playerLocationX = (int) playerLocation.getX();
            playerLocationY = (int) playerLocation.getY();
            playerLocationZ = (int) playerLocation.getZ();
        }
        if (scroll == null) {
            scrollName = DEFAULT_DATABASE_VALUE;
        } else {
            scrollName = scroll.getName();
        }
        controller.addLog(playerName, playerUuid, scrollName, System.currentTimeMillis(), playerWorld, playerLocationX, playerLocationY, playerLocationZ);
    }
}
