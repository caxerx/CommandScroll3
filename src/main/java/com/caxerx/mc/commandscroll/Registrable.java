package com.caxerx.mc.commandscroll;

import lombok.NonNull;
import org.bukkit.entity.Player;

public interface Registrable {
    String parse(@NonNull String original, @NonNull Player player);

    boolean match(@NonNull String original);

    String getId();
}
