package com.caxerx.mc.commandscroll.placeholder;

import com.caxerx.mc.commandscroll.Registrable;
import org.bukkit.entity.Player;

import java.util.function.Function;

public class PlayerFunctionPlaceholder implements Registrable {
    private String id;
    private Function<Player, String> func;

    public PlayerFunctionPlaceholder(String id, Function<Player, String> func) {
        this.id = id;
        this.func = func;
    }

    @Override
    public String parse(String original, Player player) {
        if (player == null) return "__UNKNOWN";
        return func.apply(player);
    }

    @Override
    public boolean match(String original) {
        return original.equals("<" + id + ">");
    }

    @Override
    public String getId() {
        return id;
    }
}
