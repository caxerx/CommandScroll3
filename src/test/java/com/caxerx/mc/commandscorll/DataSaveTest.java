package com.caxerx.mc.commandscorll;

import com.caxerx.mc.commandscroll.scroll.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;

public class DataSaveTest {
    @Test
    public void commandSaveTest() {
        Command cmd = new CommandBuilder().player().set("fuck").build();
        String cmdStr = new Gson().toJson(cmd);
        System.out.println(cmdStr);
        Command cmd2 = new CommandBuilder().console().set("really small dick").build();
        String cmd2Str = new Gson().toJson(cmd2);
        System.out.println(cmd2Str);
        Command cmd3 = new CommandBuilder().permission().set("fuck").appendPermission("proceed").appendPermission("rat.meow").appendPermission("wow.*").build();
        String cmd3Str = new Gson().toJson(cmd3);
        System.out.println(cmd3Str);

        Gson gson = new GsonBuilder().registerTypeAdapter(Command.class, new CommandDeserializer()).create();
        Command des = gson.fromJson(cmdStr,Command.class);
        System.out.println(des instanceof PlayerCommand);
        System.out.println(des instanceof AdminCommand);
        Command des2 = gson.fromJson(cmd2Str,Command.class);
        System.out.println(des2 instanceof ConsoleCommand);
        System.out.println(des2 instanceof AdminCommand);
        Command des3 = gson.fromJson(cmd3Str,Command.class);
        System.out.println(des3 instanceof PermissionCommand);
        System.out.println(des3 instanceof AdminCommand);

    }
}
