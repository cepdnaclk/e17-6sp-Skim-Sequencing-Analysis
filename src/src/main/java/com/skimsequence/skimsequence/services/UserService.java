package com.skimsequence.skimsequence.services;
import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;
import com.skimsequence.skimsequence.NGSApplication;

import java.io.Reader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class UserService {
    public static String preferencePath = "env/preferences.json";
    public static URL pref_url = NGSApplication.class.getResource(preferencePath);

    //To set preferences
    public static void updatePreference(String key, String value){
        FileService.writeJson(key, value, preferencePath);
    }

    public static JsonObject getAllPreferences() {
        return FileService.readJson(preferencePath);
    }

    //To update user preferences
    public static void updatePreferences (){
        try {
            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get(pref_url.getPath()));

            // create parser
            JsonObject parser = (JsonObject) Jsoner.deserialize(reader);

            System.out.println(parser);

            //close reader
            reader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void getAllInstalledPlugins(){
        try {
            // create a reader
            URL url = NGSApplication.class.getResource(preferencePath);
            System.out.println("url = " + url);
            Reader reader = Files.newBufferedReader(Paths.get(url.getPath()));
            System.out.println("reader = " + reader);
            // create parser
            JsonArray installed_plugins = (JsonArray) Jsoner.deserialize(reader);
            System.out.println(installed_plugins);
            System.out.println("hello");
            installed_plugins.forEach(entry -> {
                System.out.println(entry.getClass().getSimpleName());
            });

            for (int i = 0; i < installed_plugins.size(); i++){
                System.out.println(installed_plugins.get(i));
            }

            //close reader
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
