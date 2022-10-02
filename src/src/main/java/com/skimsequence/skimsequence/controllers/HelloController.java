package com.skimsequence.skimsequence.controllers;

import com.skimsequence.skimsequence.wrappers.FastPlast;
import com.skimsequence.skimsequence.wrappers.GetOrganelle;
import com.skimsequence.skimsequence.wrappers.NovoPlasty;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import com.skimsequence.skimsequence.services.CLIService;
import com.skimsequence.skimsequence.services.FileService;

import java.util.Objects;

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
    @FXML private TextField assemblyName;

    private CLIService cli = new CLIService();
    private String fileOne = "";
    private String fileTwo = "";
    private String assemblyTool = "FastPlast";
    private String assemblyFolderName = "";

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


    //On selecting the pipeline to call the necessary wrapper
    @FXML
    protected void onSelPipeline(){

    }

    @FXML
    protected void updateName(){
        //Set the name for the assembly process to make a folder and store output - give the name as input to the tool
        assemblyFolderName = assemblyName.getText();
        System.out.println(assemblyFolderName);
        outputLog.getItems().add("Getting ready to start " + assemblyFolderName);

    }

    //To get the absolute path for input file 1
    @FXML
    protected void onBrowseFileOne() {
        try {
            String [] filePath = FileService.getAbsolutePath();
            outputLog.getItems().add("Opening " + filePath[1]);
            fileOne = filePath[0];

        } catch(Exception e) {
            resultsText.setText("Error in retrieving file!");
        }
    }

    //To get the absolute path for input file 2
    @FXML
    protected void onBrowseFileTwo() {
        try {
            String [] filePath = FileService.getAbsolutePath();
            outputLog.getItems().add("Opening " + filePath[1]);
            fileOne = filePath[0];

        } catch(Exception e) {
            resultsText.setText("Error in retrieving file!");
        }

        pipeSteps.getItems().set(0, "Choose file(s) [DONE]");
    }

    //On selecting the assembly tool for the pipeline
    @FXML
    protected void onSelGetOrganelle(){

        assemblerSelect.setText("GetOrganelle");
        assemblyTool = "GetOrganelle";
        outputLog.getItems().add("GetOrganelle Selected");

        pipeSteps.getItems().set(1, "Choose assembly tool [DONE]");
    }

    @FXML
    protected void onSelFastPlast(){

        assemblerSelect.setText("FastPlast");
        assemblyTool = "FastPlast";
        outputLog.getItems().add("FastPlast Selected");

        pipeSteps.getItems().set(1, "Choose assembly tool [DONE]");
    }

    @FXML
    protected void onSelNovoPlasty(){

        assemblerSelect.setText("NovoPlasty");
        assemblyTool = "NovoPlasty";
        outputLog.getItems().add("NovoPlasty Selected");

        pipeSteps.getItems().set(1, "Choose assembly tool [DONE]");
    }

    //For the middle pane
    //Gets user preferences and calls file services for pre-processing (calls UserServices and FileServices)

    //For advanced options - open a new dialog box

    //To start the assembly process
    @FXML
    protected Boolean startAssembly (){ //Call necessary wrapper
        updateName(); //Set name

        Boolean state = false;
        try{
            if(Objects.equals(assemblyTool, "FastPlast")){
                FastPlast tool = new FastPlast();
                //Set other user preferences
                state = tool.startAssembly(fileOne, fileTwo, assemblyFolderName);

                outputLog.getItems().add("Running FastPlast");


            }else if(Objects.equals(assemblyTool, "GetOrganelle")){
                GetOrganelle tool = new GetOrganelle();
                //Set other user preferences
                state = tool.startRunFromReads(fileOne, fileTwo, assemblyFolderName);

                outputLog.getItems().add("Running GetOrganelle");


            }else if(Objects.equals(assemblyTool, "NovoPlasty")){
                NovoPlasty tool = new NovoPlasty();
                state = tool.startAssembly(fileOne, fileTwo, assemblyFolderName);
                outputLog.getItems().add("Running NovoPlasty");
            }else{}

        }catch (Exception e){
            System.out.println(e);
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