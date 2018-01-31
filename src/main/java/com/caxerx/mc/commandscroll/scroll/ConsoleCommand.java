package com.caxerx.mc.commandscroll.scroll;

import lombok.Data;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.Player;

@Data
public class ConsoleCommand extends Command {
    protected ConsoleCommand() {
    }

    @Override
    public void execute(Player player) {
        throw new NotImplementedException();
    }
}
