package com.caxerx.mc.commandscroll.placeholder;

import com.caxerx.mc.commandscroll.Registrable;
import lombok.NonNull;
import org.bukkit.entity.Player;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VariablePlaceholder implements Registrable {
    private VariableManager varManager;
    private static Pattern varPattern = Pattern.compile("<var:(.+)>");

    public VariablePlaceholder() {
        this.varManager = VariableManager.getInstance();
    }

    @Override
    public String parse(@NonNull String original, @NonNull Player player) {
        Matcher matcher = varPattern.matcher(original);
        matcher.matches();
        return varManager.get(matcher.group(1));
    }

    @Override
    public boolean match(@NonNull String original) {
        Matcher matcher = varPattern.matcher(original);
        return matcher.matches() && varManager.contains(matcher.group(1));
    }

    @Override
    public String getId() {
        return "var";
    }
}
