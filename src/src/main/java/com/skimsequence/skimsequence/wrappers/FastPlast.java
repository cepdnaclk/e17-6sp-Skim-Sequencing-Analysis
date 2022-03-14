package com.skimsequence.skimsequence.wrappers;

import com.skimsequence.skimsequence.services.CLIService;

public class FastPlast {

    private static CLIService cli = new CLIService();

    //Installation
    //To create directory - Create directory under Chloroplast
    public static Boolean createDir (){ //Not necessary
        Boolean state = false;
        String command = "";
        String result = "";
        try{
            result = cli.exec(command);
            System.out.println(result);
            state = true;

        } catch (Exception e){

        }

        return state;
    }

    //To clone GitHub repository in the correct directory
    public static Boolean cloneRepos (){
        Boolean state = false;
        String command = "git clone https://github.com/mrmckain/Fast-Plast.git";
        String result = "";
        try{
            result = cli.exec(command);
            System.out.println(result);
            state = true;

        } catch (Exception e){

        }

        return state;
    }


    //To install dependencies
    public static Boolean installDependencies (){
        Boolean state = false;
        String command1 = "cd Fast-Plast"; //Set path - run the INSTALL.pl script found in the Fast-Plast repository
        String command2 = "perl INSTALL.pl";
        String command3 = ""; //Enter All when they ask whether they want to automatically install the dependencies for us.

        //Dependencies will be installed in Fast-Plast/bin/
        //Dependencies - Trimommatic, bowtie2, spades, bowtie1, sspace, blast, jellyfish, afin
        String result = "";

        try{
            result = cli.exec(command1);
            System.out.println(result);

            result = cli.exec(command2);
            System.out.println(result);

            state = true;

        } catch (Exception e){

        }

        return state;
    }

    //Running
    //Get input file path and start running the tool
    //Input files are in FASTQ format
    public static Boolean startAssembly (String file1, String file2){
        Boolean state = false;
        String path = "cd "; //Go to the fast-plast directory
        //Add a name to the command. Add other additional options. Get them as user preferences.
        String command = "perl fast-plast.pl -1 %s -2 %s --name %s --bowtie_index All --coverage_analysis --clean light";
        try{
            String result = cli.exec(command);
            state = true;
        }catch(Exception e){
            state = false;
        }
        return state;
    }

    //To halt execution

    //Output
    //To retrieve output and logs

}
