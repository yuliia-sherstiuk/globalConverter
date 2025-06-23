# Global Converter


## Introduction

Gotta Convert 'Em All!' This project aims to create a Java application that allows users to translate messages into different numerical bases.

## Features

- **String Conversion**: The application allows users to translate messages into different numerical bases : octal, hexadecimal, binary, or text.

- **Input Validation**: It checks that the input string contains only alphabetical and/or numerical characters. If the inpu is invalid, an error message is displayed, prompting the uses to enter a string.

- **Base Selection**: Users can choose the desired conversion base. If the entered base is invalid, an error message is shown.

- **Reversible Conversion**: Any conversion can be reversed, allowing for bidirectional translation.

- **Encryption and Decryption**: The application incorporates a simple encryption algorithm, Caesar cipher. Users can specify the desired encryption key.

## Command Line Options

The following options are available to run the program:

- To convert to hexadecimal: '-h' or 'hexadecimal'
- To convert to octal: '-o' or 'octal'
- To convert to decimal: '-d' or 'decimal'
- To convert to binary: '-b' or 'binary'
- To convert to text: '-t' or 'text

## Project Structure

The project is organizes into several classes for better modularity and readability:
 - **Main**: The main class to run the application.
 - **Menu**: The menu class to display the menu and user inputs
 - **Converter**: The class responsible for conversions between different bases.
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
│       │   │   ├── example/     
│       │   │   │   ├── ...
│       │   │   │   ├── ...
│       │   │   │   └── ...      
│       │
│       └── resources/          
│
├── lib/                        
│
├── README.md                   
├── .gitignore                   
└── pom.xml      
```

## Skills Developed

- Programming in Java.
- Knowledge of numerical bases.
- Understanding of encryption concepts.
- Development of solutions.

## Conclusion

This project is an opportunity to practice programming skils and learn new techniques.
