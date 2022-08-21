package com.caesercipherdecoder;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CipherControllerTest {

    private Cipher request;
    private final int shiftValue = 5;
    private final String plaintext = "this is a testing message to begin working";
    private final String cipherText = "ymnx nx f yjxynsl rjxxflj yt gjlns btwpnsl";

    @Autowired
    private CipherController controllerTest;

    @Test
    void getEncryption() {
        request = new Cipher(plaintext, shiftValue);
        assertEquals(cipherText, controllerTest.getEncryption(request));
    }

    @Test
    void getDecryption() {
        request = new Cipher(cipherText, shiftValue);
        assertEquals(plaintext, controllerTest.getDecryption(request));
    }

    @Test
    void getDecryptionNoShift() {
        request = new Cipher(cipherText);
        assertTrue(controllerTest.getDecryptionNoShift(request).contains(plaintext));
    }
}