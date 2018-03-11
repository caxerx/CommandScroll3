package com.caxerx.mc.commandscroll.placeholder;

import com.caxerx.mc.commandscroll.CommandScroll;
import com.caxerx.mc.commandscroll.FileManager;
import com.google.gson.Gson;
import lombok.NonNull;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.util.FileUtil;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
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

    public String put(@NonNull String key, @NonNull String value) {
        String rt = variableMap.put(key, value);
        FileManager.saveToFile(this, new File(CommandScroll.getInstance().getDataFolder(), "variable.json"));
        return rt;
    }

    public void remove(@NonNull String key) {
        variableMap.remove(key);
    }

    public boolean contains(@NonNull String variable) {
        return variableMap.containsKey(variable);
    }

    public String get(@NonNull String variable) {
        return variableMap.get(variable);
    }

    public HashMap<String, String> getVariableMap() {
        return variableMap;
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
