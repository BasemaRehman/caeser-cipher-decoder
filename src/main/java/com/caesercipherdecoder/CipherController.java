package com.caesercipherdecoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CipherController {
    @Autowired
    public CipherService cipherService;

    @PostMapping(consumes="application/json", value = "/api/v1/getEncryption")
    public String getEncryption(@RequestBody Cipher cipher){
        return cipherService.getEncryption(cipher.getInputString(), cipher.getShiftValue());
    }

    @PostMapping(consumes="application/json", value = "/api/v1/getDecryption")
    public String getDecryption(@RequestBody Cipher cipher){
        return cipherService.getDecryptionWithShift(cipher.getInputString(), cipher.getShiftValue());
    }

    @PostMapping(consumes="application/json", value = "/api/v1/noShift")
    public List<String> getDecryptionNoShift(@RequestBody Cipher cipher){
        return cipherService.getDecryptionWithoutShift(cipher.getInputString());
    }
}
