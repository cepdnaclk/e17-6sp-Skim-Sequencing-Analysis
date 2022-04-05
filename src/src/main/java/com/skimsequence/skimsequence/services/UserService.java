package com.skimsequence.skimsequence.services;

import com.github.cliftonlabs.json_simple.JsonObject;

public class UserService {
    public static String preferencePath = "env/preferences.json";
    private static JsonObject preferences = FileService.readJson(preferencePath);

    //To set a preference
    public static boolean setPreference(String key, String value){
        FileService.printJson(getAllPreferences());
        return FileService.writeJson(key, value, preferencePath);
        // FileService.printJson(getAllPreferences());
    }

    // To get the cached preferences
    public static JsonObject getAllPreferences() {
        return preferences;
    }

    //To update user preferences (after changes cache back)
    public static void updatePreferences (){ preferences = FileService.readJson(preferencePath); }

}
