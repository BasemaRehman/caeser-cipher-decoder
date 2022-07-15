package com.caesercipherdecoder.model;

import java.util.Random;

public class Cipher {

    public Cipher(){
    }

    //If a shift value is not provided for excryption, it can be generated here first
    public int getShiftValue(){
        Random rand = new Random();
        return rand.nextInt(25);
    }

    //Encryption is (x + n) mod 26
    //input will reflect the case of the original post request
    public String getEncryption(String inputText, int shiftValue){
        StringBuilder ciphertext = new StringBuilder();

        for(char c : inputText.toCharArray()){
            if(c != ' '){
                int numericalVal = ((c - 'a') + shiftValue) % 26;
                char newValue = (char) (numericalVal + 'a');
                ciphertext.append(newValue);
            } else{
                ciphertext.append(c);
            }
        }
        return ciphertext.toString();
    }

    //Decryption is (x - n) mod 26
    public String getDecryptionWithShift(String inputText, int shiftValue){
        StringBuilder plaintext = new StringBuilder();

        for(char c : inputText.toCharArray()){
            if(c != ' '){
                int numericalVal = ((c - 'a') - shiftValue) % 26;
                char newValue = (char) (numericalVal + 'a');
                plaintext.append(newValue);
            }else{
                plaintext.append(c);
            }
        }
        return plaintext.toString();
    }
}
