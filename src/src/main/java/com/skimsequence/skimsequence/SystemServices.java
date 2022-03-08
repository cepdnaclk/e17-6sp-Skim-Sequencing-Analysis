package com.skimsequence.skimsequence;

import java.net.URL;
import java.net.URLConnection;

public class SystemServices {

    public String runningSystem() {
        return System.getProperty("os.name");
    }

    //To check for connectivity
    public static boolean isConnected() {
        try {
            URL url = new URL("http://anaconda.org/");
            URLConnection connection = url.openConnection();
            connection.connect();
            return true;
        }
        catch (Exception e) {
            // System.out.println("Internet Not Connected");
            return false;
        }
    }

    //To check and retrieve system info
    public void getSysInfo (){

    }
}
