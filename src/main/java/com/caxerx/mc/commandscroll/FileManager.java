package com.caxerx.mc.commandscroll;

import com.google.gson.Gson;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class FileManager {

    public static void saveToFile(Object obj, File file, Gson gson) {
        try {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdir();
            }
            if (!file.exists()) {
                file.createNewFile();
            }
            String data = gson.toJson(obj);
            FileUtils.writeStringToFile(file, data, Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveToFile(Object obj, File file) {
        saveToFile(obj, file, new Gson());
    }

    public static <T> T fromFile(Class<T> type, File file, Gson gson) {
        if (!file.exists()) {
            return null;
        }
        try {
            return gson.fromJson(FileUtils.readFileToString(file, Charset.defaultCharset()), type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static <T> T fromFile(Class<T> type, File file) {
        return fromFile(type, file, new Gson());
    }
}
