package com.caxerx.mc.commandscroll.log;

import lombok.Data;

@Data
public class QueryResult {
    private final String playerName;
    private final String scrollName;
    private final String world;
    private final int x;
    private final int y;
    private final int z;
    private final long time;

    public QueryResult(String playerName, String scrollName, String world, int x, int y, int z, long time) {
        this.playerName = playerName;
        this.scrollName = scrollName;
        this.world = world;
        this.x = x;
        this.y = y;
        this.z = z;
        this.time = time;
    }
}
