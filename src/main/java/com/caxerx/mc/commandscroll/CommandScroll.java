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
import com.caxerx.mc.commandscroll.scroll.PermissionManager;
import com.caxerx.mc.commandscroll.scroll.ScrollManager;
import com.caxerx.mc.commandscroll.scroll.command.CommandDeserializer;
import com.caxerx.mc.commandscroll.scroll.command.ExecutableCommand;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class CommandScroll extends JavaPlugin {

    private Permission perms;

    private static Plugin instance;
    private static Gson gson;

    public static Plugin getInstance() {
        return instance;
    }

    public static Gson getGson() {
        return gson;
    }

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
        if (!getDataFolder().exists()) {
            getDataFolder().mkdir();
        }

        instance = this;
        setupPermissions();

        if (FileManager.fromFile(VariableManager.class, new File(getDataFolder(), "variable.json")) == null) {
            new VariableManager();
        }


        gson = new GsonBuilder().registerTypeAdapter(ExecutableCommand.class, new CommandDeserializer()).create();
        if (FileManager.fromFile(ScrollManager.class, new File(getDataFolder(), "scrolls.json"), gson) == null) {
            new ScrollManager();
        }


        new CommandSelectManager();
        new DatabaseController(new File(getDataFolder() + File.separator + "log.db"));
        new ConditionParser();
        new PermissionManager(perms);
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
