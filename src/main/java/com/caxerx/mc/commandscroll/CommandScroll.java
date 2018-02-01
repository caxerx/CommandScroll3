package com.caxerx.mc.commandscroll;

import com.caxerx.mc.commandscroll.command.CommandHandler;
import com.caxerx.mc.commandscroll.command.CommandSelectManager;
import com.caxerx.mc.commandscroll.command.core.DefaultCommand;
import com.caxerx.mc.commandscroll.command.editor.DefaultEditorCommand;
import com.caxerx.mc.commandscroll.scroll.ScrollManager;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class CommandScroll extends JavaPlugin {

    private Permission perms;

    private boolean setupPermissions() {
        RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
        perms = rsp.getProvider();
        return perms != null;
    }

    @Override
    public void onLoad() {
        //
    }

    @Override
    public void onEnable() {
        setupPermissions();
        new ScrollManager();
        new CommandSelectManager();
        CommandHandler cmdexec = new CommandHandler();
        getCommand("commandscroll").setExecutor(cmdexec);
        getCommand("commandscrollvariable").setExecutor(cmdexec);
        getCommand("commandscrolleditor").setExecutor(cmdexec);
        cmdexec.registerCommand(new DefaultCommand());
        cmdexec.registerCommand(new DefaultEditorCommand());
    }
}
