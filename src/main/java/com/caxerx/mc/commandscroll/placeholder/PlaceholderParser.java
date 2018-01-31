package com.caxerx.mc.commandscroll.placeholder;

import com.caxerx.mc.commandscroll.Registrable;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlaceholderParser {
    private List<Registrable> registeredPlaceholder = new ArrayList<>();

    public void registerPlaceholder(Registrable placeholder) {
        for (Registrable existPlaceholder : registeredPlaceholder) {
            if (placeholder.getId().equals(existPlaceholder.getId())) {
                return;
            }
        }
        registeredPlaceholder.add(placeholder);
    }

    public String parse(String cmd, Player player) {
        Pattern regexMatcher = Pattern.compile("<.+?>");
        Matcher matcher = regexMatcher.matcher(cmd);
        int next = 0;
        String replacedCmd = cmd;
        while (matcher.find(next)) {
            String placeholder = cmd.substring(matcher.start(), matcher.end());
            String parsed = placeholderParse(placeholder, player);
            replacedCmd = replacedCmd.replaceAll(placeholder, parsed);
            next = matcher.end();
        }
        return replacedCmd;
    }

    public String placeholderParse(String preMatchPlaceholder, Player player) {
        for (Registrable placeholder : registeredPlaceholder) {
            if (placeholder.match(preMatchPlaceholder)) {
                return placeholder.parse(preMatchPlaceholder, player);
            }
        }
        return preMatchPlaceholder;
    }
}
