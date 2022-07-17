package com.caesercipherdecoder.model;

import java.util.Random;
//All messages must have characters between a-z to work and must be in lower case
//Try to add functionality for other characters (e.g. ? / .)
public class Cipher {

    public Cipher(){
    }

    //If a shift value is not provided for excryption, it can be generated here first
    public int setShiftValue(){
        Random rand = new Random();
        return rand.nextInt(25);
    }

    //Encryption is (x + n) mod 26
    private static final char LETTER_A = 'a';
    private static final char LETTER_Z = 'z';
    private static final int ALPHABET_SIZE = LETTER_Z - LETTER_A + 1;
    private static final double[] ENGLISH_LETTERS_PROBABILITIES = {0.073, 0.009, 0.030, 0.044, 0.130, 0.028, 0.016, 0.035, 0.074, 0.002, 0.003, 0.035, 0.025, 0.078, 0.074, 0.027, 0.003, 0.077, 0.063, 0.093, 0.027, 0.013, 0.016, 0.005, 0.019, 0.001};

    //Encryption is (x + n) mod 26
    public String getEncryption(String inputString, int shiftValue) {
        StringBuilder ciphertext = new StringBuilder();
        for (char character : inputString.toCharArray()) {
            if (character != ' ') {
                int originalAlphabetPosition = character - 'a';
                int newAlphabetPosition = (originalAlphabetPosition + shiftValue) % 26;
                char newCharacter = (char) ('a' + newAlphabetPosition);
                ciphertext.append(newCharacter);
            } else {
                ciphertext.append(character);
            }
        }

        return ciphertext.toString();
    }
    //Decryption is (x - n) mod 26
    public String getDecryptionWithShift(String inputString, int shiftValue) {
        return getEncryption(inputString, 26 - (shiftValue % 26));
    }
}