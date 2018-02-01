package com.caxerx.mc.commandscroll.scroll.command;

import lombok.NonNull;
import org.bukkit.entity.Player;

public interface Executable {
    void execute(@NonNull Player player);
}
