//class Converter
package com.globalconverter;
import java.util.ArrayList;




import com.globalconverter.converters.TextAscii;
import com.globalconverter.converters.AsciiHex;
import com.globalconverter.converters.AsciiBinary;
import com.globalconverter.converters.AsciiOctal;

/**
 * Wrapper class to unify access to all converters, applies facade design pattern
 */
public class Converter{

        TextAscii asciiConverter= new TextAscii();
        AsciiHex hexConverter= new AsciiHex();
        AsciiBinary binaryConverter=new AsciiBinary();
        AsciiOctal octalConverter=new AsciiOctal();

    /**
     * convert text to ascii and return the result as a String
     * @param textToTranslate
     * @return String of ascii values
     */
    public String textToAsciiString(String textToTranslate){
        StringBuilder result = new StringBuilder();
        for(Integer value: asciiConverter.textToAscii(textToTranslate)){
            result.append(value);
            result.append(" ");
        }
        return result.toString();
    }

    /**
     * Convert a string of ascii values into a String. the values will be input by the user so it takes a String
     * @param asciiToTranslate String of ascii values. each value must be separated by a space
     * @return String of translated text
     */
    public String asciiToTextString(String asciiToTranslate){
        ArrayList<Integer> asciiList = new ArrayList<Integer>();
        String[] inputCopy=asciiToTranslate.split(" ");
        for (String value: inputCopy){
            asciiList.add(Integer.parseInt(value));
        }
        return asciiConverter.asciiToText(asciiList);
    }

    /**
     * takes in text, turns it into ascii and then turns that into binary
     * @param textToTranslate String of text
     * @return String of binary values
     */
    public String textToBinaryString(String textToTranslate){
        ArrayList<Integer>asciiValues = asciiConverter.textToAscii(textToTranslate);
        return binaryConverter.asciiToBinary(asciiValues);
    }

    /**
     * takes in a string of binary values and converts that into a String
     * @param binaryToTranslate String of binary values
     * @return String of text
     */
    public String binaryToTextString(String binaryToTranslate){
        ArrayList<Integer> asciiValues=binaryConverter.binaryToAscii(binaryToTranslate);
        StringBuilder toBeConverted=new StringBuilder();
        for(Integer value: asciiValues){
            toBeConverted.append(value);
            toBeConverted.append(" ");
        }

        String finalString=toBeConverted.toString();

        return asciiToTextString(finalString);
    }

    /**
     * takes in a string of text→ascii→octal
     * @param textToTranslate String of text to translate
     * @return String of octal values of said string
     */
    public String textToOctalString(String textToTranslate){
        ArrayList<Integer> asciiValues= asciiConverter.textToAscii(textToTranslate);

        return octalConverter.asciiToOctal(asciiValues);
    }

    /**
     * takes in a String of octal values →ascii →String of text
     * @param octalToTranslate
     * @return
     */
    public String octalToTextString(String octalToTranslate){
        ArrayList<Integer> asciiValues= octalConverter.octalToAscii(octalToTranslate);
        StringBuilder toBeConverted=new StringBuilder();
        for(Integer value: asciiValues){
            toBeConverted.append(value);
            toBeConverted.append(" ");
        }

        String finalString=toBeConverted.toString();

        return asciiToTextString(finalString);
    }

    /**
     * takes in a string of text→ascii→hex
     * @param textToTranslate String of text to translate
     * @return String of hex values of said string
     */
    public String textToHexString(String textToTranslate){
        ArrayList<Integer> asciiValues= asciiConverter.textToAscii(textToTranslate);

        return hexConverter.asciiToHex(asciiValues);
    }

    /**
     * takes in a String of hex values →ascii →String of text
     * @param hexToTranslate
     * @return
     */
    public String hexToTextString(String hexToTranslate){
        ArrayList<Integer> asciiValues= hexConverter.hexToAscii(hexToTranslate);
        StringBuilder toBeConverted=new StringBuilder();
        for(Integer value: asciiValues){
            toBeConverted.append(value);
            toBeConverted.append(" ");
        }

        String finalString=toBeConverted.toString();

        return asciiToTextString(finalString);
    }
}