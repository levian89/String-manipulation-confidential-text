package ro.fasttrackit;

import java.util.Arrays;

public class StringsRunner {
    public static void main(String[] args) {
        String str = "alabala";
        char ch = 'A';
        String[] myStringArray1 = {"Ana", "are", "mere"};
        String[] myStringArray2 = {"mere", "Ana", "pere"};
        String phrase = "Ana are mere si merele sunt multe";
        System.out.println(countCharInAString(str, ch));
        System.out.println(returnReplacedString(str));
        System.out.println(findAStringInAnArray(myStringArray1, "Ana"));
        System.out.println(returnArrayOfStrings(phrase));
        System.out.println(returnStringConfidentialText("Ana are mere multe are si pere bune", myStringArray2));
        System.out.println(returnArrayOfStringConfidentialText("Ana are mere multe are si pere bune", myStringArray2));
    }


    public static int countCharInAString(String str, char ch) {
        int count = 0;
        char ch1 = Character.toLowerCase(ch);
        String str1 = str.toLowerCase();
        for (int i = 0; i < str.length(); i++)
            if (str1.charAt(i) == ch1) {
                count++;
            }
        return count;
    }

    public static String returnReplacedString(String str) {

        String replaced = "";
        for (int i = 0; i < str.length(); i++) {
            char c = '*';
            replaced = replaced + c;
        }
        return replaced;
    }

    public static boolean findAStringInAnArray(String[] arrayOfStrings, String str) {
        for (String str1 : arrayOfStrings) {
            if (str1.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public static String returnArrayOfStrings(String phrase) {
        String[] arrayOfStrings = phrase.split(" ");
        return Arrays.toString(arrayOfStrings);
    }

    public static String returnStringConfidentialText(String phrase, String[] arrayOfStrings) {

        String replaced = "";
        for (String str : arrayOfStrings) {
            replaced = phrase.replace(str, returnReplacedString(str));
            phrase = replaced;
        }
        return replaced;
    }

    public static String returnArrayOfStringConfidentialText(String phrase, String[] arrayOfStrings) {

        String arrayOfStringsOfPhrase = returnArrayOfStrings(phrase);
        String replaced = "";
        for (String str : arrayOfStrings) {
            replaced = arrayOfStringsOfPhrase.replace(str, returnReplacedString(str));
            arrayOfStringsOfPhrase = replaced;
        }
        return replaced;
    }
}