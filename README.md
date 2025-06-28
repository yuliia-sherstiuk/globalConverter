# Global Converter


## Introduction

Gotta Convert 'Em All!' This project aims to create a Java application that allows users to translate messages into different numerical bases.

## Features

- **String Conversion**: The application allows users to translate messages into different numerical bases : octal, hexadecimal, binary, or text.

- **Input Validation**: It checks that the input string contains only alphabetical and/or numerical characters. If the inpu is invalid, an error message is displayed, prompting the uses to enter a string.

- **Base Selection**: Users can choose the desired conversion base. If the entered base is invalid, an error message is shown.

- **Reversible Conversion**: Any conversion can be reversed, allowing for bidirectional translation.

- **Encryption and Decryption**: The application incorporates 4 encryptions algorithms, Caesar, Simple substitution, Xor and Vigenere. Users can specify the desired encryption key.

## Command Line Options

The following options are available to run the program:

To convert:
- hexadecimal: '-h' or 'hexadecimal'
- octal: '-o' or 'octal'
- decimal: '-d' or 'decimal'
- binary: '-b' or 'binary'
- text: '-t' or 'text

To encrypt:
1 - Caesar
2 - Simple Substitution
3 - XOR
4 - Vigenere

## Project Structure

The project is organizes into several classes for better modularity and readability:
 - **Main**: The main class to run the application.
 - **Menu**: The menu class to display the menu and user inputs
 - **Converters**: The directory with all the files responsible for conversions between different bases.
 - **Converter**: The class that manage converters methods.
 - **Validator**: The class for validating user inputs.
 - **Cipher**: The class for managing the encryption and decryption of strings.

```
globalConverter/
│
├── src/                        
│   ├── main/                    
│   │   ├── java/               
│   │   │   ├── com/           
│   │   │   │   ├── globalconverter/
│   │   │   │   │   ├── converters/
│   │   │   │   │   │   ├── AsciiBinary.java 
│   │   │   │   │   │   ├── AsciiHex.java  
│   │   │   │   │   │   ├── AsciiOctal.java
│   │   │   │   │   │   └── TextAscii.java
│   │   │   │   │   ├── Main.java  
│   │   │   │   │   ├── Converter.java 
│   │   │   │   │   ├── Validator.java
│   │   │   │   │   ├── Cipher.java 
│   │   │   │   │   └── Menu.java
│   │   │   │
│   │   │   └── resources/
│   │   │       └── ...    
│   │
│   └── test/                   
│       ├── java/              
│       │   ├── com/           
│       │   │   ├── globalconverter/     
│       │   │   │   ├── CipherTest.java
│       │   │   │   └── ValidatorTest.java      
│       │
│       └── resources/          
│
├── lib/                        
│
├── README.md                   
├── .gitignore                   
└── pom.xml      
```

## Class Diagram

```
+-------------------------------------------+
|                Converter                  |
+-------------------------------------------+
| - asciiConverter: TextAscii               |
| - hexConverter: AsciiHex                  |
| - binaryConverter: AsciiBinary            |
| - octalConverter: AsciiOctal              |
+-------------------------------------------+
| + textToAsciiString(String): String       |
| + asciiToTextString(String): String       |
| + textToBinaryString(String): String      |
| + binaryToTextString(String): String      |
| + textToOctalString(String): String       |
| + octalToTextString(String): String       |
| + textToHexString(String): String         |
| + hexToTextString(String): String         |
+-------------------------------------------+

+-------------------------------------------+
|               TextAscii                   |
+-------------------------------------------+
| - asciiTable: HashMap<Character, Integer> |
| - reverseAsciiTable: HashMap<Integer,     |
|                                Character> |
+-------------------------------------------+
| + textToAscii(String): ArrayList<Integer> |
| + asciiToText(ArrayList<Integer>): String |
+-------------------------------------------+

+-------------------------------------------+
|               AsciiBinary                 |
+-------------------------------------------+
| + asciiToBinary(ArrayList<Integer>):      |
|                                    String |
| + binaryToAscii(String): ArrayList        |
|                                 <Integer> |
+-------------------------------------------+

+-------------------------------------------+
|                AsciiHex                   |
+-------------------------------------------+
| + asciiToHex(ArrayList<Integer>): String  |
| + hexToAscii(String): ArrayList<Integer>  |
+-------------------------------------------+

+-------------------------------------------+
|               AsciiOctal                  |
+-------------------------------------------+
| + asciiToOctal(ArrayList<Integer>):       |
|                                   String  |
| + octalToAscii(String): ArrayList         |
|                                <Integer>  |
+-------------------------------------------+

+-------------------------------------------+
|                 Cipher                    |
+-------------------------------------------+
| + caesarEncrypt(String, int): String      |
| + caesarDecrypt(String, int): String      |
| + substitutionEncrypt(String, String):    |
|                                    String |
| + substitutionDecrypt(String, String):    |
|                                    String |
| + xorCipher(String, String): String       |
| + vigenereEncrypt(String, String): String |
| + vigenereDecrypt(String, String): String |
+-------------------------------------------+

+-------------------------------------------+
|                Validator                  |
+-------------------------------------------+
| + isValidMenuChoice(String): boolean      |
| + isValidBase(String): boolean            |
| + isYesNo(String): boolean                |
| + isValidSubstitutionKey(String): boolean |
| + isValidVigenereKey(String): boolean     |
| + isValidXORKey(String): boolean          |
| + encodeTextToBase(String, String):String |
| + decodeBaseToText(String, String):String |
| + encryptCesar(String, int): String       |
| + decryptCesar(String, int): String       |
| + encryptXOR(String, String): String      |
| + decryptXOR(String, String): String      |
| + encryptVigenere(String, String): String |
| + decryptVigenere(String, String): String |
| + encryptSubstitution(String, String):    |
|                                    String |
| + decryptSubstitution(String, String):    |
|                                    String |
+-------------------------------------------+

+-------------------------------------------+
|                  Menu                     |
+-------------------------------------------+
| + main(String[]): void                    |
+-------------------------------------------+

+-------------------------------------------+
|                  Main                     |
+-------------------------------------------+
| + main(String[]): void                    |
+-------------------------------------------+

```
## Skills Developed

- Programming in Java.
- Knowledge of numerical bases.
- Understanding of encryption concepts.
- Development of solutions.

## Conclusion

This project is an opportunity to practice programming skills and learn new techniques.
