package com.skimsequence.skimsequence.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @Test
    void test_setPreference() {
        UserService.setPreference("a", "b");
    }

    @Test
    void test_updatePreferences() {
    }

    @Test
    void test_getAllInstalledPlugins(){
        UserService.getAllInstalledPlugins();
    }
}