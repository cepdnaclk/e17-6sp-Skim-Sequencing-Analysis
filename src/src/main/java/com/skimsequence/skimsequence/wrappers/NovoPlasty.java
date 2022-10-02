package com.skimsequence.skimsequence.wrappers;

import com.skimsequence.skimsequence.services.CLIService;

public class NovoPlasty {
    private static CLIService cli = new CLIService();

    public NovoPlasty(){ //Constructor

    }

    //Installation
    //To create directory
    public static Boolean createDir (){ //Not necessary
        boolean state = false;
        String command = "";
        String result = "";
        try{
            result = cli.exec(command);
            System.out.println(result);
            state = true;

        } catch (Exception e){
            System.out.println(e);
        }

        return state;
    }

    //To clone GitHub repository in the correct directory
    public static Boolean cloneRepos (){
        Boolean state = false;
        String command = "git clone https://github.com/ndierckx/NOVOPlasty.git";
        String result = "";
        try{
            //Check connection first
            result = cli.exec(command);
            System.out.println(result);
            state = true;

        } catch (Exception e){
            System.out.println(e);
        }

        return state;
    }

    //Setup configuration file according to user input
    public void setupConfigFile (String file1, String file2){

    }

    //Running : get more parameters if necessary
    public Boolean startAssembly (String file1, String file2, String folderName){
        boolean state = false;
        String path = "cd ";             //FIXME:Go to the NovoPlasty directory
        //Add a name to the command. Add other additional options. Get them as user preferences.
        //First setup the config file
        setupConfigFile(file1, file2);

        //Start assembling
        String command = "perl NOVOPlasty4.3.pl -c config.txt";

        try{
            String result = cli.exec(command);
            //Get output when it is done
            getOutputLogs();

            state = true;
        }catch(Exception e){
            System.out.println(e);
        }
        return state;
    }


    //To halt execution

    //Output
    //To retrieve output and logs
    public static void getOutputLogs (){
        //Go to the directory with output logs
        String command = "cd "; //FIXME:Set path
        String result = "";

        try{

            result = cli.exec(command);
            System.out.println(result);

            //Open output files
            command = "xdg-open {filename}"; //FIXME:Set path

            try{
                result = cli.exec(command);
                System.out.println(result);

            }catch (Exception e){
                System.out.println(e);
            }


        } catch (Exception e){
            System.out.println(e);
        }




    }
}
