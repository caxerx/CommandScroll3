package com.caxerx.mc.commandscroll.scroll;

import lombok.AccessLevel;
import lombok.Setter;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class PermissionCommand extends Command {
    @Setter(AccessLevel.PROTECTED)
    List<String> permission = new ArrayList<>();

    protected PermissionCommand() {
    }

    @Override
    public void execute(Player player) {
        throw new NotImplementedException();
    }
}
