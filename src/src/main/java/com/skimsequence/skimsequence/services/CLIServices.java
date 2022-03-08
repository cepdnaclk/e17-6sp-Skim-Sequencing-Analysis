package com.skimsequence.skimsequence.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CLIServices {

    //To execute commands in the command line and get output
    public String exec(String command) throws Exception{
        Runtime run = Runtime.getRuntime();
        Process process = run.exec(command);
        process.waitFor();
        BufferedReader buf = new BufferedReader(new InputStreamReader(process. getInputStream()));
        String out = null;
        String result = "";
        while ((out = buf.readLine())!=null){
            result += out + "\n";
        }
        return result;
    }

    //To create a virtual environment
    public void createVenv () {

    }

    //To handle sudo permissions
    public void handleSudo (){

    }

    //To check the version of other tools like python, java
    public void checkVersion (){

    }

}
