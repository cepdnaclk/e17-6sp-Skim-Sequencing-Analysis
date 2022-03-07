package com.skimsequence.skimsequence.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import com.skimsequence.skimsequence.services.CLIService;
import javafx.stage.FileChooser;

import java.io.File;

public class HelloController {
    @FXML private Label welcomeText;
    @FXML private Button button;
    @FXML private Label resultsText;

    private CLIService cli = new CLIService();

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
        button.setText("Clicked");
    }
    @FXML
    protected void onRunButtonClick() {
        String command = "ls -l";
        String result;

        try {
            result = cli.exec(command);
            resultsText.setText(result);


        } catch (Exception e) {
            resultsText.setText("Error in command execution!");
        }
    }

    @FXML
    protected void onBrowseClick() {
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Browse for file path");
            File file = fileChooser.showOpenDialog(null);
            if (file != null) {
                // Shows the absolute file path
                resultsText.setText("Opening " + file.getPath());

            } else {
                System.out.println("File not selected."); // A file was not chosen
            }

        } catch(Exception e) {
            resultsText.setText("Error in retrieving file!");
        }
    }

}