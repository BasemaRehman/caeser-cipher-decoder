package com.caesercipherdecoder;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CipherInterfaceTest {

    private final String plainText = "hello";
    private final String cipherText = "olssv";
    private final int shiftValue = 7;
    private final List<String> list = Arrays.asList(new String[]{"wtaad", "hello"});

    @Autowired
    private CipherInterface underTest;


    @Test
    void getEncryption() {
        assertEquals(cipherText,underTest.getEncryption(plainText, shiftValue));
    }

    @Test
    void getDecryptionWithShift() {
        assertEquals(plainText, underTest.getDecryptionWithShift(cipherText, shiftValue));
    }

    @Test
    void getDecryptionWithoutShift() {
        assertEquals(list, underTest.getDecryptionWithoutShift(cipherText));
    }
}