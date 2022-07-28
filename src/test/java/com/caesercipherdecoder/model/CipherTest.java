package com.caesercipherdecoder.model;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public class CipherTest {
    public static Cipher cipher;

    @BeforeAll
    public static void setup(){
        cipher = new Cipher();
    }

    @Test
    public void itShouldCorrectlyEncode(){
        String plaintext = "hello";
        String actual = cipher.getEncryption(plaintext, 3);
        Assertions.assertEquals("khoor", actual);
    }

    @Test
    public void itShouldCorrectlyEncodeASentence(){
        String plaintext = "this is a test message";
        String expected = "wklv lv d whvw phvvdjh";
        String actual = cipher.getEncryption(plaintext, 3);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void itShouldCorrectlyEncodeTheUpperBound(){
        String plaintext = "hello";
        String expected = "gdkkn";
        String actual = cipher.getEncryption(plaintext, 25);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void itShouldCorrectlyEncodeTheLowerBound(){
        String plaintext = "hello";
        String expected = "ifmmp";
        String actual = cipher.getEncryption(plaintext, 1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void itShouldReturnANumberBelowTwentySix() throws NoSuchAlgorithmException {
        int actual = cipher.setShiftValue();
        Assertions.assertTrue(actual < 26);
    }

    @Test
    public void itShouldCorrectlyDecodeASentenceWithShift(){
        String ciphertext = "wklv lv d whvw phvvdjh";
        String expected = "this is a test message";
        String actual = cipher.getDecryptionWithShift(ciphertext, 3);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void itShouldCorrectlyDecodeWithShift(){
        String ciphertext = "khoor";
        String actual = cipher.getDecryptionWithShift(ciphertext, 3);
        Assertions.assertEquals("hello", actual);
    }

    @Test
    public void itShouldDecodeALongMessageWithoutShift(){
        String ciphertext = "xli erexsqc sj e fefc alepi mw zivc gsqtpib mrhiih";
        String expected = "the anatomy of a baby whale is very complex indeed";
        Assertions.assertEquals(cipher.getDecryptionWithoutShift(ciphertext), expected);
    }

    @Test
    public void itShouldReturnAllPossibleDecryptions(){
        String ciphertext = "lipps qc reqi";
        String lowestChiSquaredValue = cipher.getDecryptionWithoutShift(ciphertext);
        List<String> additionalValues = cipher.getAdditionalDecryptions(ciphertext);
        Assertions.assertTrue(additionalValues.contains("hello my name"));
    }
}



