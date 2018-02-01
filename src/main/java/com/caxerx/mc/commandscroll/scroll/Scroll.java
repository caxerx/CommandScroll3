package com.caxerx.mc.commandscroll.scroll;

import com.caxerx.mc.commandscroll.scroll.command.ExecutableCommand;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data
public class Scroll implements Cloneable {
    @Setter(AccessLevel.PRIVATE)
    private String name;
    @Setter
    private List<ExecutableCommand> commands;

    public Scroll(@NonNull String name) {
        this.name = name;
        commands = new ArrayList<>();
    }

    public Scroll(@NonNull String name, @NonNull List<ExecutableCommand> commands) {
        this.name = name;
        this.commands = commands;
    }

    public void addCommand(@NonNull ExecutableCommand cmd) {
        commands.add(cmd);
    }

    @Override
    public Scroll clone() {
        return ScrollManager.getInstance().cloneScroll(this);
    }
}
