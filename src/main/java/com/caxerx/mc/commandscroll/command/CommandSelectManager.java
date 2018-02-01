package com.caxerx.mc.commandscroll.command;

import com.caxerx.mc.commandscroll.ScrollNotExistException;
import com.caxerx.mc.commandscroll.scroll.Scroll;
import com.caxerx.mc.commandscroll.scroll.ScrollManager;
import com.caxerx.mc.commandscroll.scroll.command.ExecutableCommand;
import lombok.NonNull;
import org.bukkit.command.CommandSender;

import java.util.HashMap;

public class CommandSelectManager {
    private HashMap<CommandSender, Scroll> selectedScroll;
    private HashMap<CommandSender, ExecutableCommand> selectedCommand;
    private HashMap<CommandSender, Integer> selectedCommandIndex;
    private ScrollManager scrollManager;
    private static CommandSelectManager instance;

    public CommandSelectManager() {
        selectedScroll = new HashMap<>();
        selectedCommand = new HashMap<>();
        selectedCommandIndex = new HashMap<>();
        scrollManager = ScrollManager.getInstance();
        instance = this;
    }

    public static CommandSelectManager getInstance() {
        return instance;
    }

    public boolean isSelectedScroll(@NonNull CommandSender sender) {
        return selectedScroll.containsKey(sender);
    }

    public boolean isSelectedCommand(@NonNull CommandSender sender) {
        return selectedCommand.containsKey(sender);
    }

    public Scroll selectScroll(@NonNull CommandSender sender, @NonNull String scrollName) {
        if (scrollManager.getScroll(scrollName) == null) {
            throw new ScrollNotExistException(scrollName);
        }
        Scroll scroll = scrollManager.getScroll(scrollName);
        selectedScroll.put(sender, scroll.clone());
        return scroll;
    }

    public ExecutableCommand selectCommand(@NonNull CommandSender sender, int commandIndex) {
        ExecutableCommand command = getSelectedScroll(sender).getCommands().get(commandIndex);
        selectedCommand.put(sender, command);
        selectedCommandIndex.put(sender, commandIndex);
        return command;
    }

    public ExecutableCommand setSelectedCommand(@NonNull CommandSender commandSender, ExecutableCommand command) {
        getSelectedScroll(commandSender).getCommands().set(selectedCommandIndex.get(commandSender), command);
        selectedCommand.put(commandSender, command);
        return command;
    }

    public Scroll getSelectedScroll(@NonNull CommandSender sender) {
        return selectedScroll.get(sender);
    }

    public ExecutableCommand getSelectedCommand(@NonNull CommandSender sender) {
        return selectedCommand.get(sender);
    }

    public void commitEdit(@NonNull CommandSender sender) {
        Scroll scroll = getSelectedScroll(sender);
        scrollManager.setScroll(scroll.getName(), scroll);
        selectedCommandIndex.remove(sender);
        selectedCommand.remove(sender);
        selectedScroll.remove(sender);
    }

}
