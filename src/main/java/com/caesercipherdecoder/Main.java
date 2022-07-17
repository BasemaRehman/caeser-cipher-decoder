package com.caesercipherdecoder;

import com.caesercipherdecoder.model.Cipher;

public class Main {
    public static void main(String[] args) {
        Cipher cipher = new Cipher();
        System.out.println(cipher.getEncryption("hello my name", 4));
        System.out.println(cipher.getDecryptionWithShift("lipps qc reqi", 4));
    }

}
