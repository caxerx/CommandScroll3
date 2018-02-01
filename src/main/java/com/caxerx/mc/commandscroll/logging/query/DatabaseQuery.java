package com.caxerx.mc.commandscroll.logging.query;

import com.caxerx.mc.commandscroll.command.display.TimeDisplayConfig;
import lombok.NonNull;

public class DatabaseQuery {
    private TimeDisplayConfig timeConfig;

    public DatabaseQuery(@NonNull TimeDisplayConfig timeConfig) {
        this.timeConfig = timeConfig;
    }
}
