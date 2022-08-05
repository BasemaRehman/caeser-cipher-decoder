package com.caesercipherdecoder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CipherServiceTest {

    @Mock
    private CipherInterface cipherInterface;
    private CipherService underTest;

    @BeforeEach
    void setUp(){
        underTest = new CipherService(cipherInterface);
    }

    @Test
    void itShouldCallGetEncryptionMethod() {
        //Given
        String inputString = "hello";
        int shiftValue = 7;
        //When
        underTest.getEncryption(inputString, shiftValue);
        //Then
        verify(cipherInterface).getEncryption(inputString, shiftValue);
    }

    @Test
    void itShouldCallGetEncryptionMethodWithoutShift() {
        //Given
        String inputString = "hello";
        //When
        underTest.getEncryption(inputString, -1);
        //Then
        verify(cipherInterface).getEncryption(inputString, -1);
    }

    @Test
    void itShouldCallGetDecryptionWithShiftMethod() {
        //Given
        String inputString = "qwerty";
        int shiftValue = 7;
        //When
        underTest.getDecryptionWithShift(inputString, shiftValue);
        //Then
        verify(cipherInterface).getDecryptionWithShift(inputString, shiftValue);
    }

    @Test
    void itShouldCallgetDecryptionWithoutShiftMethod() {
        //Given
        String inputString = "hello";
        //When
        underTest.getDecryptionWithoutShift(inputString);
        //Then
        verify(cipherInterface).getDecryptionWithoutShift(inputString);
    }
}