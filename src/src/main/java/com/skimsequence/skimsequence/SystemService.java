package com.skimsequence.skimsequence;

import java.net.NetworkInterface;
import java.net.URL;
import java.net.URLConnection;

public class SystemService {
    public String runningSystem() {
        return System.getProperty("os.name");
    }
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
}
