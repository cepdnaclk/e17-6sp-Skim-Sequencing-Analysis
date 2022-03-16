package com.skimsequence.skimsequence.controllers;

import com.skimsequence.skimsequence.wrappers.FastPlast;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import com.skimsequence.skimsequence.services.CLIService;
import com.skimsequence.skimsequence.services.FileService;

public class HelloController {
    //Initialize all GUI components
    @FXML private Button execbtn;
    @FXML private Label welcomeText;
    @FXML private Button button;
    @FXML private Label resultsText;

    ToggleGroup pipelineSelect = new ToggleGroup();

    @FXML private RadioButton chloroplast;
    @FXML private RadioButton mitochondria;
    @FXML private RadioButton its;

    @FXML private ListView<String> pipeSteps;

    @FXML private ListView<String> outputLog;

    @FXML private MenuButton assemblerSelect;

    private CLIService cli = new CLIService();
    private String fileOne = "";
    private String fileTwo = "";
    private String assemblyTool = "FastPlast";

    private static String[] chloroplastSteps = {
                                                "Choose file(s)",
                                                "Choose assembly tool",
                                                "Attempt assembly",
                                                "Annotation"
                                                };

    @FXML
    public void initialize() {
        /* Set styling and grouping for pipeline select buttons in toolbar */
        chloroplast.getStyleClass().remove("radio-button");
        chloroplast.getStyleClass().add("toggle-button");

        mitochondria.getStyleClass().remove("radio-button");
        mitochondria.getStyleClass().add("toggle-button");

        its.getStyleClass().remove("radio-button");
        its.getStyleClass().add("toggle-button");

        chloroplast.setToggleGroup(pipelineSelect);
        mitochondria.setToggleGroup(pipelineSelect);
        its.setToggleGroup(pipelineSelect);

        pipelineSelect.selectToggle(chloroplast);

        /* Populate Pipeline Steps ListView */
        pipeSteps.getItems().addAll(chloroplastSteps);

    }

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
        assemblerSelect.setText("GetOrganelle");
        outputLog.getItems().add("GetOrganelle Selected");

        pipeSteps.getItems().set(1, "Choose assembly tool [DONE]");
    }

    //To get the absolute path for input file 1
    @FXML
    protected void onBrowseFileOne() {
        try {
            String absPath = FileService.getAbsolutePath();
            outputLog.getItems().add("Opening " + absPath);     //FIXME: Show filename instead of absPath
            fileOne = absPath;

        } catch(Exception e) {
            resultsText.setText("Error in retrieving file!");
        }
    }

    //To get the absolute path for input file 2
    @FXML
    protected void onBrowseFileTwo() {
        try {
            String absPath = FileService.getAbsolutePath();
            outputLog.getItems().add("Opening " + absPath);
            fileTwo = absPath;

        } catch(Exception e) {
            resultsText.setText("Error in retrieving file!");
        }

        pipeSteps.getItems().set(0, "Choose file(s) [DONE]");
    }

    //For the middle pane
    //Gets user preferences and calls file services for pre-processing (calls UserServices and FileServices)
    @FXML
    protected void updateMiddle(){

    }

    //To start the assembly process
    @FXML
    protected Boolean startAssembly (){ //Call necessary wrapper
        Boolean state = false;
        try{
            if(assemblyTool == "FastPlast"){
                FastPlast tool = new FastPlast();
                state = tool.startAssembly(fileOne, fileTwo);
                //Set other user preferences
            }

        }catch (Exception e){

        }
        return state;
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