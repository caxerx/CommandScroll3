package com.caxerx.mc.commandscroll.scroll.command;

import lombok.NonNull;

import java.util.List;

public class CommandBuilder {
    private ExecutableCommand cmd;

    public CommandBuilder set(@NonNull String command) {
        if (cmd != null) {
            cmd.setCommand(command);
            return this;
        }
        throw new RuntimeException("Unspecified command type");
    }

    public CommandBuilder appendPermission(@NonNull String perm) {
        if (cmd instanceof PermissionCommand) {
            ((PermissionCommand) cmd).addPermission(perm);
            return this;
        }
        throw new RuntimeException("Not a permission command");
    }

    public CommandBuilder setPermission(@NonNull List<String> perms) {
        if (cmd instanceof PermissionCommand) {
            ((PermissionCommand) cmd).setPermission(perms);
            return this;
        }
        throw new RuntimeException("Not a permission command");
    }

    public CommandBuilder player() {
        this.cmd = new PlayerCommand();
        return this;
    }

    public CommandBuilder console() {
        this.cmd = new ConsoleCommand();
        return this;
    }

    public CommandBuilder admin() {
        this.cmd = new AdminCommand();
        return this;
    }

    public CommandBuilder permission() {
        this.cmd = new PermissionCommand();
        return this;
    }

    public ExecutableCommand build() {
        return cmd;
    }
}

