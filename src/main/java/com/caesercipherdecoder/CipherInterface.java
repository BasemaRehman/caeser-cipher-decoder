package com.caesercipherdecoder;

import java.util.List;

public interface CipherInterface {

    public String getEncryption(String inputString, int shiftValue);

    public String getDecryptionWithShift(String inputString, int shiftValue);

    public List<String> getDecryptionWithoutShift(String inputString);
}
