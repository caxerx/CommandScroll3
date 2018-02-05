package com.caxerx.mc.commandscroll;

import com.caxerx.mc.commandscroll.command.CommandHandler;
import com.caxerx.mc.commandscroll.command.CommandSelectManager;
import com.caxerx.mc.commandscroll.command.core.DefaultCoreCommand;
import com.caxerx.mc.commandscroll.command.editor.DefaultEditorCommand;
import com.caxerx.mc.commandscroll.command.log.DefaultLogCommand;
import com.caxerx.mc.commandscroll.command.var.DefaultVariableCommand;
import com.caxerx.mc.commandscroll.logging.DatabaseController;
import com.caxerx.mc.commandscroll.logging.query.condition.ConditionParser;
import com.caxerx.mc.commandscroll.placeholder.VariableManager;
import com.caxerx.mc.commandscroll.scroll.ScrollManager;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

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
        new VariableManager();
        new DatabaseController(new File(getDataFolder() + File.separator + "log.db"));
        new ConditionParser();
        CommandHandler cmdexec = new CommandHandler(this);

        DefaultCoreCommand corenode = new DefaultCoreCommand();
        DefaultEditorCommand editornode = new DefaultEditorCommand();
        DefaultVariableCommand varnode = new DefaultVariableCommand();
        DefaultLogCommand lognode = new DefaultLogCommand();

        cmdexec.registerCommand("commandscroll", corenode);
        cmdexec.registerCommand("commandscrolleditor", editornode);
        cmdexec.registerCommand("commandscrollvariable", varnode);
        cmdexec.registerCommand("commandscrolllog", lognode);
    }
}
