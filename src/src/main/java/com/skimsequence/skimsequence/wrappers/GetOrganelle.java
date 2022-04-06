package com.skimsequence.skimsequence.wrappers;

import com.skimsequence.skimsequence.services.CLIService;

public class GetOrganelle {
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

    //To get the GitHub repository into the correct directory
    public static Boolean cloneRepos (){
        Boolean state = false;
        String command1 = "curl -L https://github.com/Kinggerm/GetOrganelle/archive/1.7.4.1.tar.gz | tar zx";
        String command2 = "mv GetOrganelle-1.7.4.1 GetOrganelle";
        String result = "";

        try{
            //Check connection first
            result = cli.exec(command1);
            System.out.println(result);

            try{
                result = cli.exec(command2);
                System.out.println(result);
                state = true;
            }catch(Exception e){

            }

        } catch (Exception e){

        }

        return state;
    }

    public static Boolean installDependencies (){
        Boolean state = false;
        String command1 = "cd GetOrganelle"; //FIXME: Set path first
        String command2 = "curl -L https://github.com/Kinggerm/GetOrganelleDep/releases/download/v1.6.0/v1.6.0-linux.tar.gz | tar zx";
        String command3 = "cd ..";

        //Dependencies - Bowtie2, spades, ncbi-blast
        String result = "";

        try{
            //Check connection first
            result = cli.exec(command1);
            System.out.println(result);

            result = cli.exec(command2);
            System.out.println(result);

            result = cli.exec(command3);

            state = true;

        } catch (Exception e){

        }

        return state;
    }

    public static Boolean installGetOrganelle (){
        Boolean state = false;
        String command1 = "pip install ./GetOrganelle";
        String result = "";

        try{
            //Check connection first
            result = cli.exec(command1);
            System.out.println(result);

            state = true;

        } catch (Exception e){

        }

        return state;


    }

    //Run
    //From reads
    public static Boolean startRunFromReads (String file1, String file2, String folderName){
        Boolean state = false;
        String path = "cd ";                 //FIXME:Go to the GetOrganelle directory
        //Add other additional options. Get them as user preferences.
        //Input files - forward.fq and reverse.fq
        String command = String.format("get_organelle_from_reads.py -1 %s -2 %s -o %s ", file1, file2, folderName);
        try{
            String result = cli.exec(command);
            state = true;
        }catch(Exception e){
            state = false;
        }
        return state;
    }



}
