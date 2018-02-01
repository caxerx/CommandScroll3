package com.caxerx.mc.commandscroll.command;

import com.caxerx.mc.commandscroll.scroll.Scroll;
import com.caxerx.mc.commandscroll.scroll.command.ExecutableCommand;
import javafx.util.Pair;
import lombok.NonNull;
import org.bukkit.command.CommandSender;

import java.util.HashMap;

public class CommandSelectManager {
    private HashMap<CommandSender, Scroll> selectedScroll;
    private HashMap<CommandSender, Pair<Integer, ExecutableCommand>> selectedCommand;
    private static CommandSelectManager instance;

    public CommandSelectManager() {
        selectedScroll = new HashMap<>();
        selectedCommand = new HashMap<>();
        instance = this;
    }

    public static CommandSelectManager getInstance() {
        return instance;
    }

    public boolean isSelectedScroll(@NonNull CommandSender sender) {
        return false;
    }

    public boolean isSelectedCommand(@NonNull CommandSender sender) {
        return false;
    }

    public void selectScroll(@NonNull CommandSender sender, @NonNull Scroll scroll) {
        selectedScroll.put(sender, scroll.clone());
    }

    public void selectCommand(@NonNull CommandSender sender, int commandIndex, @NonNull ExecutableCommand command) {
        selectedCommand.put(sender, new Pair<>(commandIndex, command.clone()));
    }

    public Scroll getSelectedScroll(@NonNull CommandSender sender) {
        return selectedScroll.get(sender);
    }

    public Pair<Integer, ExecutableCommand> getSelectedCommand(@NonNull CommandSender sender) {
        return selectedCommand.get(sender);
    }

}
