# Global Converter


## Introduction

Gotta Convert 'Em All!' This project aims to create a Java application that allows users to translate messages into different numerical bases.

## Features

- **Line Command**: The application allows users to type line commands.

- **String Conversion**: The application allows users to translate messages into different numerical bases : octal, hexadecimal, binary, or text.

- **Input Validation**: It checks that the input string contains only alphabetical and/or numerical characters. If the input is invalid, an error message is displayed, prompting the user to enter a string.

- **Base Selection**: Users can choose the desired conversion base. If the entered base is invalid, an error message is shown.

- **Reversible Conversion**: Any conversion can be reversed, allowing for bidirectional translation.

- **Encryption and Decryption**: The application incorporates 4 encryptions algorithms, Caesar, Simple substitution, Xor and Vigenere. Users can specify the desired encryption key.

## Options using traditionnal menu

The following options are available to run the program:

To convert:
- hexadecimal: '-h' or 'hexadecimal'
- octal: '-o' or 'octal'
- decimal: '-d' or 'decimal'
- binary: '-b' or 'binary'
- text: '-t' or 'text

To encrypt:
- Caesar
- Simple Substitution
- XOR
- Vigenere

## Command line possibilities

First of all : compile using mvn or line command
```bash
 mvn compile
``` 
Than navigate to the good directory
```bash
cd target/classes
``` 

Than use the command line below.

PS : To run the interactive menu : 
```bash
java com.globalconverter.Menu
``` 

### 1. ENCODING ONLY (Base Only)

#### Long Form:
```bash
java com.globalconverter.Menu hexadecimal "Hello World"
java com.globalconverter.Menu octal "Hello World"
java com.globalconverter.Menu decimal "Hello World"
java com.globalconverter.Menu binary "Hello World"
java com.globalconverter.Menu text "Hello World"
```

#### Short Form:
```bash
java com.globalconverter.Menu -h "Hello World"
java com.globalconverter.Menu -o "Hello World"
java com.globalconverter.Menu -d "Hello World"
java com.globalconverter.Menu -b "Hello World"
java com.globalconverter.Menu -t "Hello World"
```

### 2. ENCODING + CAESAR CIPHER

#### With Long Form Base:
```bash
java com.globalconverter.Menu hexadecimal "Hello World" -a caesar -k 3
java com.globalconverter.Menu hexadecimal "Hello World" -a cesar -k 3
java com.globalconverter.Menu octal "Hello World" -a caesar -k 5
java com.globalconverter.Menu decimal "Hello World" -a caesar -k 10
java com.globalconverter.Menu binary "Hello World" -a caesar -k 1
java com.globalconverter.Menu text "Hello World" -a caesar -k 7
```

#### With Short Form Base:
```bash
java com.globalconverter.Menu -h "Hello World" -a caesar -k 3
java com.globalconverter.Menu -o "Hello World" -a caesar -k 5
java com.globalconverter.Menu -d "Hello World" -a caesar -k 10
java com.globalconverter.Menu -b "Hello World" -a caesar -k 1
java com.globalconverter.Menu -t "Hello World" -a caesar -k 7
```

#### Variants with "key" Instead of "-k":
```bash
java com.globalconverter.Menu -h "Hello World" -a caesar key 3
java com.globalconverter.Menu hexadecimal "Hello World" -a caesar key 3
```

### 3. ENCODING + SUBSTITUTION CIPHER

```bash
java com.globalconverter.Menu -h "Hello World" -a substitution -k "ZYXWVUTSRQPONMLKJIHGFEDCBA"
java com.globalconverter.Menu hexadecimal "Hello World" -a substitution -k "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
java com.globalconverter.Menu -o "Hello World" -a substitution key "QWERTYUIOPASDFGHJKLZXCVBNM"
```

### 4. ENCODING + XOR CIPHER

```bash
java com.globalconverter.Menu -h "Hello World" -a xor -k "secret"
java com.globalconverter.Menu hexadecimal "Hello World" -a xor -k "key123"
java com.globalconverter.Menu -b "Hello World" -a xor -k "a"
java com.globalconverter.Menu octal "Hello World" -a xor key "mypassword"
```

### 5. ENCODING + VIGENERE CIPHER

```bash
java com.globalconverter.Menu -h "Hello World" -a vigenere -k "SECRET"
java com.globalconverter.Menu hexadecimal "Hello World" -a vigenere -k "password"
java com.globalconverter.Menu -d "Hello World" -a vigenere -k "KEY"
java com.globalconverter.Menu binary "Hello World" -a vigenere key "CIPHER"
```

### 6. EXAMPLES WITH DIFFERENT ARGUMENT ORDERS

```bash
# Different parameter order
java com.globalconverter.Menu "Hello World" -h -a caesar -k 3
java com.globalconverter.Menu -a caesar "Hello World" -h -k 3
java com.globalconverter.Menu -k 3 -a caesar -h "Hello World"

# Mixing long/short forms
java com.globalconverter.Menu hexadecimal "Hello World" -a caesar key 3
java com.globalconverter.Menu -h "Hello World" -a vigenere key "SECRET"
```

### 7. INVALID COMMANDS (which will display help)

```bash
# Missing the base
java com.globalconverter.Menu "Hello World" -a caesar -k 3

# Missing the text
java com.globalconverter.Menu -h -a caesar -k 3

# Completely missing arguments
java com.globalconverter.Menu

```

### IMPORTANT NOTES:

- **The text must always be in quotes** if it contains spaces.
- **A base is always required** (long or short form).
- **The text is mandatory**.
- **If `-a` is specified, `-k` is generally required** (depending on the algorithm).
- **The order of arguments may vary** (except the text, which is detected automatically).
- **Caesar keys must be integers**.
- **Substitution keys must have exactly 26 unique letters**.
- **Vigenere keys must contain only letters**.
- **XOR keys can be any non-empty string**.

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
| + substitutionProcess(String, String,     |
|                          boolean): String |
| + substitutionEncrypt(String, String):    |
|                                    String |
| + substitutionDecrypt(String, String):    |
|                                    String |
| + xorCipher(String, String): String       |
| + vigenereProcess(String, String,         |
|                          boolean): String |
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
