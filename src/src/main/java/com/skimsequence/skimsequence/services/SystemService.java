package com.skimsequence.skimsequence.services;

import java.net.URL;
import java.net.URLConnection;

public class SystemService {
    private static String system;
    private static String arch;
    private static Integer coresCount;

    public SystemService() {
        system = System.getProperty("os.name");
        arch = System.getProperty("os.arch");
        coresCount = Runtime.getRuntime().availableProcessors();
    }

    // To get system information
    public static String getSystem() {
        return system;
    }
    public static String getArch() { return arch; }
    public static int getCoresCount() { return coresCount; }

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

}
