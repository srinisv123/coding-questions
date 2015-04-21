import java.util.HashMap;
import java.util.Arrays;

class StringUniqueCharacters {



    public static void main(String[] args) {
        String word = args[0];

        if (uniqueCharswithHash(word)) {
            System.out.println("Hashing technique says all unique");
        } else {
            System.out.println("Hashing technique says all not unique");
        }

        if (uniqueCharsWithSorting(word)) {
            System.out.println("Sorting technique says all unique");
        } else {
            System.out.println("Sorting technique says all not unique");
        }

    }


    public static boolean uniqueCharswithHash(String word) {

        boolean unique = true;
        HashMap<Character,Integer> chars = new HashMap<Character,Integer>();
        int len = word.length();
        Character curr;
        for (int i=0;i<len;i++) {
            curr = word.charAt(i);
            if(chars.containsKey(curr)) {
                unique = false;
                break;
            } else {
                chars.put(curr,1);
            }
        }

        return unique;
    }


    public static boolean uniqueCharsWithSorting(String word) {


        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        boolean unique = true;
        for (int i=0; i<chars.length-1; i++) {
            if (chars[i] == chars[i+1]) {
                unique= false;
                break;
            } 
        }

        return unique;
    }



}
