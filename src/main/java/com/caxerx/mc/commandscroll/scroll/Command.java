package com.caxerx.mc.commandscroll.scroll;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

public abstract class Command implements Executable {
    @Setter(AccessLevel.PROTECTED)
    protected String command;
    @Setter(AccessLevel.NONE)
    private CommandType type;

    public Command(CommandType type) {
        this.type = type;
    }
}
