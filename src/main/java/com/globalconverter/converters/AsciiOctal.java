package com.globalconverter.converters;


import java.util.ArrayList;

public class AsciiOctal {

    /**
     * translate ascii to octal. takes an arraylist from textToAscii
     * @param asciiToTranslate ArrayList<Integer> see TextAscii
     * @return String of octal values
     */
    public String asciiToOctal(ArrayList<Integer>asciiToTranslate){
        ArrayList<String> result=new ArrayList<String>();
        for (Integer asciiValue: asciiToTranslate) {
            StringBuilder octalValues = new StringBuilder();
            if (asciiValue == 0) {
                octalValues.append("0");
            } else {
                while (asciiValue > 0) {
                    int remainder = asciiValue % 8;
                    octalValues.insert(0, remainder);

                    asciiValue = asciiValue / 8;
                }
            }
            result.add(octalValues.toString());
        }

        return String.join(" ", result);
    }

    /**
     * translates octal to ascii
     * @param octalToTranslate String of octal values delimited by spaces
     * @return ArrayList<Integer> of ascii values
     */
    public ArrayList<Integer> octalToAscii(String octalToTranslate) {
        String[] splitOctals = octalToTranslate.split(" ");
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (String octalValue : splitOctals) {
            int asciiCode = 0;

            for (int i = 0; i < octalValue.length(); i++) {
                char c = octalValue.charAt(octalValue.length() - 1 - i);
                int digit = Character.getNumericValue(c);
                asciiCode += digit * Math.pow(8, i);
            }
            result.add(asciiCode);
        }
        return result;
    }
}

