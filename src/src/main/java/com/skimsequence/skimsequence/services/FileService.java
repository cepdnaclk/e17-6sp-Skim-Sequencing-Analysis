package com.skimsequence.skimsequence.services;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;
import com.skimsequence.skimsequence.NGSApplication;
import javafx.stage.FileChooser;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileService {

    //To get the absolute path for a file
    public static String getAbsolutePath (){
        String absPath = "" ;
        try{
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Browse for file path");
            File file = fileChooser.showOpenDialog(null);
            if (file != null) {
                // Shows the absolute file path
                absPath = file.getPath();
            } else {
                System.out.println("File not selected."); // A file was not chosen
            }
        } catch (Exception e){
            System.out.println("Error in retrieving file!");
        }
        return absPath;
    }

    public static void printJson(JsonObject json) {
        json.forEach((key, value) -> System.out.println(key + " : " + value));
    }

    public static void printJson(JsonArray json) {
        json.forEach(item -> System.out.println(item));
    }

    public static JsonObject readJson(String path) {
        /*
         * Returns a json object in the file at path
         */
        URL url = NGSApplication.class.getResource(path);
        JsonObject json = new JsonObject();
        try {
            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get(url.getPath()));

            // create parser
            JsonObject preferencesJson = (JsonObject) Jsoner.deserialize(reader);

            // assign to return
            json = preferencesJson;

            //close reader
            reader.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return json;
    }

    public static boolean writeJson(String key, String value, String path) {
        /*
         * Writes the key value pair to the Json file in the given path
         */
        URL url = NGSApplication.class.getResource(path);
        try {
            // create a writer
            JsonObject json = readJson(path);
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(url.getPath()));

            // update particular key value pair
            json.put(key, value);

            // write to json
            Jsoner.serialize(json, writer);
            System.out.println("Written to json file " + path);

            //close the writer
            writer.close();
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    //To write to a file
    public void writeToFile () {

    }

    //File conversion (call a tool-wrapper)
    public void convertToFastq () {

    }

    //Normalizing date (call a tool-wrapper)
    public void normalizeData (){

    }
}
