package com.caxerx.mc.commandscroll.log;

import com.caxerx.mc.commandscroll.Registrable;
import org.bukkit.entity.Player;

public class EqualDatabaseCondition implements Registrable {
    private String id;
    private String column;

    public EqualDatabaseCondition(String id, String column) {
        this.id = id;
        this.column = column;
    }

    @Override
    public String parse(String original, Player player) {
        return column + " = '" + original.replaceFirst(id + ":", "").replaceAll("(?=[]\\[+&|!(){}^\"~*?:\\\\-])", "\\\\").replaceAll("AND", "").replaceAll("OR", "") + "'";
    }

    @Override
    public boolean match(String original) {
        return original.startsWith(id + ":") && !original.endsWith(id + ":");
    }

    @Override
    public String getId() {
        return id;
    }
}
