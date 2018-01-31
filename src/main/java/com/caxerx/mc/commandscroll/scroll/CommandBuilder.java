package com.caxerx.mc.commandscroll.scroll;

import java.util.ArrayList;

public class CommandBuilder {
    String commands = "";
    ArrayList<String> permission = new ArrayList<>();
    CommandType type = CommandType.PLAYER;

    public CommandBuilder set(String cmd) {
        commands = cmd;
        return this;
    }

    public CommandBuilder permission(String perm) {
        permission.add(perm);
        return this;
    }

    public CommandBuilder type(CommandType type) {
        this.type = type;
        return this;
    }

    public Command build() {
        switch (type) {
            case PLAYER:
                PlayerCommand playerCommand = new PlayerCommand();
                playerCommand.setCommand(commands);
                return playerCommand;
            case ADMIN:
                AdminCommand adminCommand = new AdminCommand();
                adminCommand.setCommand(commands);
                return adminCommand;
            case CONSOLE:
                ConsoleCommand consoleCommand = new ConsoleCommand();
                consoleCommand.setCommand(commands);
                return consoleCommand;
            case PERMISSION:
                PermissionCommand permissionCommand = new PermissionCommand();
                permissionCommand.setPermission(permission);
                return permissionCommand;
            default:
                return null;
        }
    }
}

enum CommandType {
    PLAYER, CONSOLE, ADMIN, PERMISSION
}