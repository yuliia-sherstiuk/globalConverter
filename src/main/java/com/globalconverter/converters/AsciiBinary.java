package main.java.com.globalconverter.converters;

import java.util.ArrayList;


public class AsciiBinary{


    /**
     *Translate ascii to binary
     * @param asciiToTranslate ArrayList of integers received from TextAscii's textToBinary
     * @return String of binary values corresponding to ascii received.
     */
    public String asciiToBinary(ArrayList<Integer> asciiToTranslate) {
        ArrayList<String> result = new ArrayList<String>();


        for (Integer currentInteger : asciiToTranslate) {

            StringBuilder binaryString = new StringBuilder();

            if (currentInteger == 0) {
                binaryString.append("0");
            } else {
                while (currentInteger > 0) {

                    int remainder = currentInteger % 2;

                    binaryString.insert(0,remainder);

                    currentInteger = currentInteger / 2;
                }
            }
            result.add(binaryString.toString());
        }
        return String.join(" ", result);

    }

    /**
     * translate binary to ascii
     * @param binaryToTranslate a String of binary to be translated, see asciiToBinary for detalis
     * @return ArrayList<Integer> of ascii values
     */
    public ArrayList<Integer> binaryToAscii(String binaryToTranslate){
        String[] binaryString=binaryToTranslate.split(" ");
        ArrayList<Integer>result=new ArrayList<Integer>();

        for (String binarySequence: binaryString){
            int asciiCode=0;

            for(int i=0; i<binarySequence.length(); i++){
                char bit=binarySequence.charAt(binarySequence.length()-1-i);
                if (bit=='1'){
                    asciiCode+=(int)Math.pow(2, i);
                }
            }
            result.add(asciiCode);
        }
        return result;
    }
}
