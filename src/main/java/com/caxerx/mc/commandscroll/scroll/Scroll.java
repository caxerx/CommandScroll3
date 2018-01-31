package com.caxerx.mc.commandscroll.scroll;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.util.List;

@Data
public class Scroll {
    @Setter(AccessLevel.PRIVATE)
    private String name;
    @Setter
    private List<Command> commands;

    public Scroll(String name) {
        this.name = name;
    }

    public Scroll(String name, List<Command> commands) {
        this.name = name;
        this.commands = commands;
    }

    public void addCommand(Command cmd) {
        commands.add(cmd);
    }
}
