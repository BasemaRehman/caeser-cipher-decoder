# Caeser-Cipher-Decoder

## Basic Functionality
This API will take in either a ciphertext for decryption or 
plaintext for encryption and return the opposite

#### For Encryption: 
If a shift value is provided, the API will use this value to encrypt
If a shift value is NOT provided, the API will first generate a random 
value between 1 and 25 for use

#### For Decryption:
Where the key is known, the ciphertext is decrypted simply
Where the key is unknown, the chi-squared values of each
decryption will be calculated and the lowest will be returned

##Limitations:
1. This API will only work with English language letters
2. All characters must be in lower case. If not, they will be
converted on entry 
3. This API is only compatible with languages using the letters
in the english alphabet if the decryption key is known or only
the english language if the decryption key is unknown
4. The use of Chi-Squared to break the code is limited with shorter
messages. To mitigate this, a list of potential results will also
be returned if their Chi-Squared values are between an upper and 
lower limit
