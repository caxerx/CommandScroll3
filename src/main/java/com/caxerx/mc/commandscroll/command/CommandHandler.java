package com.caxerx.mc.commandscroll.command;

import com.google.common.collect.Lists;
import lombok.NonNull;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;

public class CommandHandler implements CommandExecutor {
    private List<CommandNode> registeredCommand = new ArrayList<>();

    public void registerCommand(@NonNull CommandNode node) {
        registeredCommand.add(node);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        try {
            for (CommandNode cmd : registeredCommand) {
                if (cmd.match(label)) {
                    return cmd.invokeCommand(sender, Lists.newArrayList(args));
                }
            }
        } catch (CommandPermissionException e) {
            sender.sendMessage("perm: " + e.getMessage());
        } catch (CommandArgumentException e) {
            sender.sendMessage("aug: " + e.getMessage());
        }
        return false;
    }
}
