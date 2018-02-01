package com.caxerx.mc.commandscroll.scroll.command;

import com.caxerx.mc.commandscroll.scroll.ScrollManager;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;
import lombok.Setter;

@Data
public abstract class ExecutableCommand implements Executable, Cloneable {
    @Setter(AccessLevel.PROTECTED)
    protected String command;
    @Setter(AccessLevel.NONE)
    private CommandType type;

    public ExecutableCommand(@NonNull CommandType type) {
        this.type = type;
    }


    @Override
    public ExecutableCommand clone() {
        return ScrollManager.getInstance().cloneCommand(this);
    }
}
