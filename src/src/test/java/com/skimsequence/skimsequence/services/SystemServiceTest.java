package com.skimsequence.skimsequence.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SystemServiceTest {

    @Test
    void test_isConnected() {
        assertTrue(SystemService.isConnected());
    }

    @Test
    void getSystem() { assertEquals("Mac OS X", SystemService.getSystem()); }

    @Test
    void getArch() { assertEquals("aarch64", SystemService.getArch()); }

    @Test
    void getCoresCount() { assertEquals(8, SystemService.getCoresCount()); }

}