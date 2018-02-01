package com.caxerx.mc.commandscorll;

import com.caxerx.mc.commandscroll.scroll.command.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;

public class DataSaveTest {
    @Test
    public void commandSaveTest() {
        ExecutableCommand cmd = new CommandBuilder().player().set("fuck").build();
        String cmdStr = new Gson().toJson(cmd);
        System.out.println(cmdStr);
        ExecutableCommand cmd2 = new CommandBuilder().console().set("really small dick").build();
        String cmd2Str = new Gson().toJson(cmd2);
        System.out.println(cmd2Str);
        ExecutableCommand cmd3 = new CommandBuilder().permission().set("fuck").appendPermission("proceed").appendPermission("rat.meow").appendPermission("wow.*").build();
        String cmd3Str = new Gson().toJson(cmd3);
        System.out.println(cmd3Str);

        Gson gson = new GsonBuilder().registerTypeAdapter(ExecutableCommand.class, new CommandDeserializer()).create();
        ExecutableCommand des = gson.fromJson(cmdStr,ExecutableCommand.class);
        System.out.println(des instanceof PlayerCommand);
        System.out.println(des instanceof AdminCommand);
        ExecutableCommand des2 = gson.fromJson(cmd2Str,ExecutableCommand.class);
        System.out.println(des2 instanceof ConsoleCommand);
        System.out.println(des2 instanceof AdminCommand);
        ExecutableCommand des3 = gson.fromJson(cmd3Str,ExecutableCommand.class);
        System.out.println(des3 instanceof PermissionCommand);
        System.out.println(des3 instanceof AdminCommand);

    }
}
