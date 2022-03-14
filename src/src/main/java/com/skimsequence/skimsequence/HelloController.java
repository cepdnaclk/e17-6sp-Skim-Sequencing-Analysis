package com.skimsequence.skimsequence;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import com.skimsequence.skimsequence.services.CLIService;

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
        } catch (Exception e){
            resultsText.setText("Error in command execution!");
        }
    }

}