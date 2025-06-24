package main.java.com.globalconverter.converters;
import java.util.ArrayList;

public class AsciiHex {

    /**
     * translate ascii to hex
     * @param asciiToTranslate ArrayList of ascii values
     * @return String of hex values
     */
    public String asciiToHex(ArrayList<Integer> asciiToTranslate){
        ArrayList<String> result=new ArrayList<String>();
        for (Integer asciiValue: asciiToTranslate) {
            StringBuilder hexValues = new StringBuilder();
            if (asciiValue == 0) {
                hexValues.append("0");
            } else {
                while (asciiValue > 0) {
                    int remainder = asciiValue % 16;
                    if (remainder<10) {
                        hexValues.insert(0, remainder);
                    }else {
                        char hexChar = (char) ('A' + (remainder - 10));
                        hexValues.insert(0, hexChar);
                    }

                    asciiValue = asciiValue / 16;
                }
            }
            result.add(hexValues.toString());
        }

        return String.join(" ", result);
    }


    /**
     * translates hex values to ascii
     * @param hexToTranslate a String of hex values to translate
     * @return ArrayList of ascii values
     */
    public ArrayList<Integer> hexToAscii (String hexToTranslate){
        String[] hexValues=hexToTranslate.split(" ");
        ArrayList<Integer> result= new ArrayList<Integer>();

        for (String hexValue: hexValues){
            int asciiCode=0;

            for (int i=0; i< hexValue.length(); i++){
                char c =hexValue.charAt(hexValue.length()-1-i);
                int digit=0;
                if (Character.isDigit(c)){
                    digit= c-'0';
                }else{
                    digit= 10+(Character.toUpperCase(c)-'A');
                }

                asciiCode+=digit* (int)Math.pow(16, i);
            }
            result.add(asciiCode);
        }

        return result;


    }

    }

