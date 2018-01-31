package com.caxerx.mc.commandscroll.placeholder;

import java.util.HashMap;

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

    public String put(String key, String value) {
        return variableMap.put(key, value);
    }

    public boolean contains(String variable) {
        return variableMap.containsKey(variable);
    }

    public String get(String variable) {
        return variableMap.get(variable);
    }
}
