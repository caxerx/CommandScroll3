package com.caxerx.mc.commandscroll.scroll.command;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class CommandDeserializer implements JsonDeserializer<ExecutableCommand> {

    @Override
    public ExecutableCommand deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        String type = jsonObject.get("type").getAsString();
        CommandBuilder commandBuilder = new CommandBuilder();
        switch (type) {
            case "CONSOLE":
                commandBuilder.console();
                break;
            case "PERMISSION":
                ArrayList<String> permission = new ArrayList<>();
                jsonObject.get("permission").getAsJsonArray().forEach(jsonElement -> {
                    permission.add(jsonElement.getAsString());
                });
                commandBuilder.permission().setPermission(permission);
                break;
            case "ADMIN":
                commandBuilder.admin();
                break;
            case "PLAYER":
            default:
                commandBuilder.player();
        }
        commandBuilder.set(jsonObject.get("command").getAsString());
        return commandBuilder.build();
    }
}
