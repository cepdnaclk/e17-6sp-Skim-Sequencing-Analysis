package com.skimsequence.skimsequence;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CLIService {
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

}
