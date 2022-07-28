package com.caesercipherdecoder.model;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
//All messages must have characters between a-z to work and must be in lower case
//Try to add functionality for other characters (e.g. ? / .)
public class Cipher {

    private static final char LETTER_A = 'a';
    private static final char LETTER_Z = 'z';
    private static final int ALPHABET_SIZE = LETTER_Z - LETTER_A + 1;
    private static final double[] ENGLISH_LETTERS_PROBABILITIES = {0.073, 0.009, 0.030, 0.044, 0.130, 0.028, 0.016, 0.035, 0.074, 0.002, 0.003, 0.035, 0.025, 0.078, 0.074, 0.027, 0.003, 0.077, 0.063, 0.093, 0.027, 0.013, 0.016, 0.005, 0.019, 0.001};
    private final double[] probabilities = new double[26];
    private int probableOffset = 0;

    public Cipher(){
        // required only for construction and to call other methods
    }

    //If a shift value is not provided for excryption, it can be generated here first
    public int setShiftValue() throws NoSuchAlgorithmException {
        Random rand = SecureRandom.getInstanceStrong();
        return rand.nextInt(25);
    }

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

    //For each offset, calculate decrypted counts and compare with english letter probabilities
    //Can only work with longer messages as shorter messages don't have enough info
    public String getDecryptionWithoutShift(String inputString){
        //calculate chi-squared
        for(int i = 1; i<ALPHABET_SIZE; i++){
            String decryptedMessage = getDecryptionWithShift(inputString, i);
            long[] decryptedCount = countLetters(decryptedMessage);
            probabilities[i] = calculateChiSquared(decryptedCount, inputString.length());
            if(probableOffset == 0 || probabilities[i] < probabilities[probableOffset]){
                probableOffset = i;
            }
        }
        return getDecryptionWithShift(inputString, probableOffset);
    }

    public List<String> getAdditionalDecryptions(String inputString){
        List<String> decryptions = new ArrayList<>();
        for(int i = 0; i<probabilities.length; i++){
            if(i != probableOffset && Math.abs(probabilities[i] - probabilities[probableOffset]) <= 1){
                decryptions.add(getDecryptionWithShift(inputString, i));
            }
        }
        return decryptions;
    }

    private long[] countLetters(String inputString){
        long[] letterCount = new long[26];
        for (char c : inputString.toCharArray()){
            if(c != ' ') {
                letterCount[c - 'a']++;
            }
        }
        return letterCount;
    }

    private double calculateChiSquared(long[] offsetCounts, long length){
        double[] expectedLettersFrequencies = Arrays.stream(ENGLISH_LETTERS_PROBABILITIES)
                .map(probability -> probability * length)
                .toArray();
        double chiValue = 0.0;
        for(int i = 0; i<ALPHABET_SIZE; i++){
            chiValue += (Math.pow((offsetCounts[i] - (expectedLettersFrequencies[i])),2))
                    /ENGLISH_LETTERS_PROBABILITIES[i];
        }
        return Math.sqrt(chiValue);
    }
}