package com.caxerx.mc.commandscroll.log;

import lombok.Data;

@Data
public class QueryResult {
    private final String player_name;
    private final String scroll_name;
    private final String world;
    private final int x;
    private final int y;
    private final int z;
    private final long time;

    public QueryResult(String player_name, String scroll_name, String world, int x, int y, int z, long time) {
        this.player_name = player_name;
        this.scroll_name = scroll_name;
        this.world = world;
        this.x = x;
        this.y = y;
        this.z = z;
        this.time = time;
    }
}
