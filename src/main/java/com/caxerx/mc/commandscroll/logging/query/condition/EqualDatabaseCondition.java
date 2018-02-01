package com.caxerx.mc.commandscroll.logging.query.condition;

import com.caxerx.mc.commandscroll.Registrable;
import lombok.NonNull;
import org.bukkit.entity.Player;

public class EqualDatabaseCondition implements Registrable {
    private String id;
    private String column;

    public EqualDatabaseCondition(@NonNull String id,@NonNull String column) {
        this.id = id;
        this.column = column;
    }

    @Override
    public String parse(@NonNull String original, @NonNull Player player) {
        return column + " = '" + original.replaceFirst(id + ":", "").replaceAll("(?=[]\\[+&|!(){}^\"~*?:\\\\-])", "\\\\").replaceAll("AND", "").replaceAll("OR", "") + "'";
    }

    @Override
    public boolean match(@NonNull String original) {
        return original.startsWith(id + ":") && !original.endsWith(id + ":");
    }

    @Override
    public String getId() {
        return id;
    }
}
