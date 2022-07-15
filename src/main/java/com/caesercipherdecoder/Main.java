package com.caesercipherdecoder;

import com.caesercipherdecoder.model.Cipher;

public class Main {
    public static void main(String[] args) {
        Cipher cipher = new Cipher();
        System.out.println(cipher.getEncryption("Hello", 3));
        System.out.println(cipher.getDecryptionWithShift("Khoor", 3));
    }

}
