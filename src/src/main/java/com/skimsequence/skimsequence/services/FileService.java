package com.skimsequence.skimsequence.services;

import javafx.stage.FileChooser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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

    //To read a fq/fa file
    public void readFile () {

    }

    public static void readJSON() {

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
