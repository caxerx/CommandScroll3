package com.caxerx.mc.commandscroll.placeholder;

import lombok.NonNull;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VariableManager {
    private static VariableManager instance;
    private HashMap<String, String> variableMap; //TODO:load from file

    public VariableManager() {
        instance = this;
        variableMap = new HashMap<>();
    }

    public static VariableManager getInstance() {
        return instance;
    }

    public String put(@NonNull String key,@NonNull String value) {
        return variableMap.put(key, value);
    }

    public boolean contains(@NonNull String variable) {
        return variableMap.containsKey(variable);
    }

    public String get(@NonNull String variable) {
        return variableMap.get(variable);
    }

    public List<String> searchVariable(@NonNull String keyword) {
        List<String> result = new ArrayList<>();
        variableMap.keySet().forEach(key -> {
            if (StringUtils.getJaroWinklerDistance(keyword, key) > 0.8) {
                result.add(key);
            }
        });
        return result;
    }
}
