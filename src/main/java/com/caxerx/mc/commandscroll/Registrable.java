package com.caxerx.mc.commandscroll;

import org.bukkit.entity.Player;

public interface Registrable {
    String parse(String original, Player player);

    boolean match(String original);

    String getId();
}
