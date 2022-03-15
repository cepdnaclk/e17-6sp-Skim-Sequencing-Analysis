package com.skimsequence.skimsequence.services;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static org.junit.jupiter.api.Assertions.*;

class SystemServiceTest {

    @Test
    void runningSystem() {
        Runtime run = Runtime.getRuntime();
        Process process = run.exec(command);
        try {
            process.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        BufferedReader buf = new BufferedReader(new InputStreamReader(process. getInputStream()));
        String out = null;
        String result = "";
    }

    @Test
    void isConnected() {
    }

    @Test
    void getSysInfo() {
    }
}