package main.java.com.globalconverter.converters;
import java.util.HashMap;
import java.util.ArrayList;

/**
 * A class to handle text to ascii conversion and vice versa
 */
public class TextAscii {
    public HashMap<Character, Integer> asciiTable = new HashMap<Character, Integer>();
    public HashMap<Integer, Character> reverseAsciiTable=new HashMap<Integer, Character>();

    /**
     * TextAscii constructor, creates two dictionaries to translate text to ascii and the opposite.
     * private for singleton design pattern
     */
    private TextAscii() {
        for (char c= 'A'; c <='Z'; c++){
            asciiTable.put(c, (int)c);
        }
        //Uppercase letters ↑

        for (char c='a';c<='z';c++){
            asciiTable.put(c, (int)c);
        }
        // Lowercase letters ↑

        for (char c='0'; c<='9'; c++){
            asciiTable.put(c, (int)c);
        }
        // Numbers ↑

        for (int c=65; c<=90; c++){
            reverseAsciiTable.put(c, (char)c);
        }
        // reverse uppercase letters ↑

        for (int c=97; c<=122; c++){
            reverseAsciiTable.put(c, (char)c);
        }
        //reverse lowercase letters ↑

        for (int c=48; c<=57;c++){
            reverseAsciiTable.put(c, (char)c);
        }
        //reverse numbers ↑
    }

    /**
     * Singleton implementation for text ascii converter
     * @return TextAscii instance
     */
    public TextAscii getInstance(){
        return new TextAscii();
    }

    /**
     * takes in a string and returns an ArrayList of its ascii values
     * @param textToTranslate string to be translated
     * @return ArrayList<integer> of the ascii values
     */
    public ArrayList<Integer> textToAscii(String textToTranslate){
        ArrayList<Integer> translationResult=new ArrayList<Integer>();
        for (char letter: textToTranslate.toCharArray()){
            if (letter==' '){
                continue;
            }
            translationResult.add(asciiTable.get(letter));
        }
        return translationResult;
    }

    /**
     * takes in a String of ascii values and returns text.
     * @Warning MUST USE SPACE BETWEEN EACH ASCII CODE AND THE NEXT
     * @param asciiValues
     * @return String of ascii to text translation
     */
    public String asciiToText(String asciiValues){
        String[] formattedInput=asciiValues.split(" ");
        ArrayList<Integer> valueCodes=new ArrayList<Integer>();

        for (String code: formattedInput){
            valueCodes.add(Integer.parseInt(code));
        }

        ArrayList<Character>translation=new ArrayList<Character>();
        for (Integer code: valueCodes){
            translation.add(reverseAsciiTable.get(code));
        }

        ArrayList<String> translationResult=new ArrayList<String>();
        for (Character c: translation){
            translationResult.add(String.valueOf(c));
        }

        return String.join("", translationResult);
    }


}
