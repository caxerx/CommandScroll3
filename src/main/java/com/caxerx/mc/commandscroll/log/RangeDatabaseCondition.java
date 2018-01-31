package com.caxerx.mc.commandscroll.log;

import com.caxerx.mc.commandscroll.Registrable;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class RangeDatabaseCondition implements Registrable {

    @Override
    public String parse(String original, Player player) {
        String playerWorld;
        int playerX;
        int playerZ;
        if (player == null) {
            playerWorld = "__UNKNOWN";
            playerX = -1;
            playerZ = -1;
        } else {
            playerWorld = player.getWorld().getName();
            Location playerLocation = player.getLocation();
            playerX = (int) playerLocation.getX();
            playerZ = (int) playerLocation.getZ();
        }
        int range = 0;
        try {
            range = Integer.parseInt(original.replaceFirst("r:", ""));
        } catch (Exception e) {
            //ignore
        }
        return "world = '" + playerWorld + "' AND location_x BETWEEN " + (playerX - range) + " AND " + (playerX + range) + " AND location_z BETWEEN " + (playerZ - range) + " AND " + (playerZ + range);
    }

    @Override
    public boolean match(String original) {
        return original.startsWith("r:") && !original.endsWith("r:");
    }

    @Override
    public String getId() {
        return "r";
    }
}
