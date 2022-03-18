package com.skimsequence.skimsequence.services;
import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;
import com.skimsequence.skimsequence.NGSApplication;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Reader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;

public class UserService {
    public static String preferencePath = "env/preferences.json";
    public static URL url = NGSApplication.class.getResource(preferencePath);

    //To set preferences
    public static void updatePreference (String key, String value){
        try {
            // create a writer
            JsonObject preferences = getAllPreferences();
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(url.getPath()));

            // update particular key value pair
            preferences.put(key, value);

            // write to json
            Jsoner.serialize(preferences, writer);
            System.out.println("Updated");
            //close the writer
            writer.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static JsonObject getAllPreferences() {
        JsonObject preferences = new JsonObject();
        try {
            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get(url.getPath()));

            // create parser
            JsonObject preferencesJson = (JsonObject) Jsoner.deserialize(reader);

            // assign to return
            preferences = preferencesJson;

            //close reader
            reader.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return preferences;
    }

}
/*
Reading object or array
        try {
            // create a reader
            URL url = NGSApplication.class.getResource("env/customer.json");
            Reader reader = Files.newBufferedReader(Paths.get(url.getPath()));

            // create parser
            JsonObject parser = (JsonObject) Jsoner.deserialize(reader);

            System.out.println(parser);
                        // read projects
            JsonArray projects = (JsonArray) parser.get("projects");
            projects.forEach(entry -> {
                JsonObject project = (JsonObject) entry;
                System.out.println(project.get("title"));
                System.out.println(project.get("budget"));
            });

            //close reader
            reader.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
 */
/*
"username" : "Jhon Doe",
  "app_theme" : "Light",
  "protected" : "off",
  "password" : "",
  "default_output_storage_path" : "",
  "default_input_file_path" : ""
 */