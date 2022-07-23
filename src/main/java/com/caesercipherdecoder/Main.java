package com.caesercipherdecoder;

import com.caesercipherdecoder.model.Cipher;

public class Main {
    public static void main(String[] args) {
        Cipher cipher = new Cipher();
        System.out.println(cipher.getEncryption("The anatomy of a baby whale is very complex indeed", 4));
       // System.out.println(cipher.getDecryptionWithShift("lipps qc reqi", 4));
        System.out.println(cipher.getDecryptionWithoutShift("xli erexsqc sj e fefc alepi mw zivc gsqtpib mrhiih"));

    }

}
