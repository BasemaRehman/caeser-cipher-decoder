package com.caesercipherdecoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CipherService {

    private final CipherInterface cipherInterface;

    @Autowired
    public CipherService(CipherInterface cipherInterface){
        this.cipherInterface = cipherInterface;
    }

    public String getEncryption(String inputString, int shiftValue){
        return cipherInterface.getEncryption(inputString.toLowerCase(), shiftValue);
    }

    public String getDecryptionWithShift(String inputString, int shiftValue){
        return cipherInterface.getDecryptionWithShift(inputString.toLowerCase(), shiftValue);
    }

    public List<String> getDecryptionWithoutShift(String inputString){
        return cipherInterface.getDecryptionWithoutShift(inputString.toLowerCase());
    }

}
