package com.skimsequence.skimsequence.services;

import com.github.cliftonlabs.json_simple.JsonObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @Test
    void test_updatePreference() {
      assertTrue(UserService.setPreference("app_theme", "Light"), "Returned true: successfully updated");  ;
    }

    @Test
    void test_updatePreferences() {
        UserService.updatePreferences();
    }

    @Test
    void test_getAllPreferences() {
        UserService.getAllPreferences();
    }

}