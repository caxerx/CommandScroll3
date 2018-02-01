package com.caxerx.mc.commandscroll.logging.query.condition;

import com.caxerx.mc.commandscroll.Registrable;
import lombok.NonNull;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class ConditionParser {
    private List<Registrable> registeredCondition = new ArrayList<>();

    public void registerCondition(@NonNull Registrable placeholder) {
        for (Registrable existPlaceholder : registeredCondition) {
            if (placeholder.getId().equals(existPlaceholder.getId())) {
                return;
            }
        }
        registeredCondition.add(placeholder);
    }

    public String toSql(@NonNull String[] conditions, @NonNull Player player) {
        StringBuilder stringBuilder = new StringBuilder("SELECT * FROM UsageLog WHERE ");
        for (int i = 0; i < conditions.length; i++) {
            String parsed = parse(conditions[i], player);
            stringBuilder.append(parsed);
            if (!parsed.equals("") && i != conditions.length - 1) {
                stringBuilder.append(" AND ");
            }
        }
        return stringBuilder.append(" ORDER BY use_time DESC LIMIT 8;").toString();
    }

    public String parse(@NonNull String condition, @NonNull Player player) {
        for (Registrable conditionObj : registeredCondition) {
            if (!conditionObj.match(condition)) {
                continue;
            }
            return conditionObj.parse(condition, player);
        }
        return "";
    }
}