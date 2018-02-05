package com.caxerx.mc.commandscroll.logging.query.condition;

import com.caxerx.mc.commandscroll.Registrable;
import lombok.NonNull;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class ConditionParser {
    private List<Registrable> registeredCondition = new ArrayList<>();
    private static ConditionParser instance;

    public ConditionParser() {
        registerCondition(new EqualDatabaseCondition("w", "world"));
        registerCondition(new EqualDatabaseCondition("p", "player_name"));
        registerCondition(new EqualDatabaseCondition("u", "player_uuid"));
        registerCondition(new EqualDatabaseCondition("s", "scroll_name"));
        registerCondition(new TimeDatabaseCondition());
        registerCondition(new RangeDatabaseCondition());
        instance = this;
    }

    public static ConditionParser getInstance() {
        return instance;
    }

    public void registerCondition(@NonNull Registrable placeholder) {
        for (Registrable existPlaceholder : registeredCondition) {
            if (placeholder.getId().equals(existPlaceholder.getId())) {
                return;
            }
        }
        registeredCondition.add(placeholder);
    }

    public String toSql(@NonNull List<String> conditions, @NonNull Player player) {
        StringBuilder stringBuilder = new StringBuilder("SELECT * FROM UsageLog");
        List<String> conditionList = new ArrayList<>();
        for (String condition : conditions) {
            String parsed = parse(condition, player);
            if (!parsed.equals("")) {
                conditionList.add(parsed);
            }
        }
        if (conditionList.size() > 0) {
            stringBuilder.append(" WHERE ");
            stringBuilder.append(String.join(" AND ", conditionList));
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
