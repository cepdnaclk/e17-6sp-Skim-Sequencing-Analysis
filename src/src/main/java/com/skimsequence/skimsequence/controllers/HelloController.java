package com.skimsequence.skimsequence.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import com.skimsequence.skimsequence.services.CLIServices;
import com.skimsequence.skimsequence.services.FileServices;
import com.skimsequence.skimsequence.services.UserServices;
import com.skimsequence.skimsequence.services.SystemServices;

public class HelloController {
    //Initialize all GUI components
    @FXML private Button execbtn;
    @FXML private Label welcomeText;
    @FXML private Button button;
    @FXML private Label resultsText;

    private CLIServices cli = new CLIServices();

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
        button.setText("Clicked");
    }
    @FXML
    protected void onRunButtonClick() { //Remove
        String command = "ls -l";
        String result;

        try {
            result = cli.exec(command);
            resultsText.setText(result);


        } catch (Exception e) {
            resultsText.setText("Error in command execution!");
        }
    }

    //For the leftmost pane
    //On selecting the pipeline to call the necessary wrapper
    @FXML
    protected void onSelPipeline(){

    }

    //On selecting the assembly tool for the pipeline
    @FXML
    protected void onSelAssemblyTool(){

    }

    //To get the absolute path for the input file
    @FXML
    protected void onBrowseClick() {
        try {
            String absPath = FileServices.getAbsolutePath();
            resultsText.setText("Opening ... " + absPath);

        } catch(Exception e) {
            resultsText.setText("Error in retrieving file!");
        }
    }

    //For the middle pane
    //Gets user preferences and calls file services for pre-processing (calls UserServices and FileServices)
    @FXML
    protected void updateMiddle(){

    }

    //To start the assembly process
    @FXML
    protected void startAssembly (){ //Call necessary wrapper

    }

    //To stop/interrupt assembly
    @FXML
    protected  void stopExec (){ //Call necessary wrapper

    }

    //For the bottom pane (Recommendations)
    //Call necessary services and update pane
    @FXML
    protected void getNewRecommendations (){

    }

    //For the rightmost pane
    //To update the progress bar in the Results pane
    @FXML
    protected void updateProgressBar (){

    }

    //To update the output logs (create a text box to display these and update it)
    @FXML
    protected void displayOutputLogs (){

    }

    //Other
    //Check plugins button - should open another window - control using PluginController
    @FXML
    protected void onClickPluginInfo (){

    }










}