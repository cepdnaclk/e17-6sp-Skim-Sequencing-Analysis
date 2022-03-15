package com.skimsequence.skimsequence.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CLIServiceTest {
    static CLIService cli;
    @BeforeEach
    void setUp() {
        CLIService cli = new CLIService();
    }

    @Test
    void exec() {
        try {
            cli.exec("ls");
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @Test
    void createVenv() {
    }

    @Test
    void handleSudo() {
    }

    @Test
    void checkVersion() {
    }
}