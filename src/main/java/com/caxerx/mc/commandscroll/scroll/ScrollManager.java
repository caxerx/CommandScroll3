package com.caxerx.mc.commandscroll.scroll;

import com.caxerx.mc.commandscroll.CommandScroll;
import com.caxerx.mc.commandscroll.FileManager;
import com.caxerx.mc.commandscroll.scroll.command.CommandDeserializer;
import com.caxerx.mc.commandscroll.scroll.command.ExecutableCommand;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.NonNull;

import java.io.File;
import java.util.HashMap;

public class ScrollManager {
    private HashMap<String, Scroll> registeredScroll = new HashMap<>();
    transient private static ScrollManager instance;
    transient private static Gson gson;

    public ScrollManager() {
        instance = this;
        gson = CommandScroll.getGson();
    }

    public static ScrollManager getInstance() {
        return instance;
    }

    public void addScroll(@NonNull Scroll scroll) {
        registeredScroll.put(scroll.getName(), scroll);
    }

    public Scroll getScroll(@NonNull String name) {
        return registeredScroll.get(name);
    }

    public void setScroll(@NonNull String name, @NonNull Scroll scroll) {
        registeredScroll.put(name, scroll);
    }

    public HashMap<String, Scroll> getAllScroll() {
        return registeredScroll;
    }

    public boolean hasScroll(String scrollName) {
        return registeredScroll.containsKey(scrollName);
    }

    public ExecutableCommand cloneCommand(ExecutableCommand cmd) {
        return gson.fromJson(gson.toJson(cmd), ExecutableCommand.class);
    }

    public Scroll cloneScroll(Scroll scroll) {
        return gson.fromJson(gson.toJson(scroll), Scroll.class);
    }

    public void commitChange() {
        FileManager.saveToFile(this, new File(CommandScroll.getInstance().getDataFolder(), "scroll.json"), CommandScroll.getGson());
    }

}
