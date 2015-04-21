import java.util.HashMap;
class FirstNonRepeatingCharacter {


    public static void main (String[] args) {

        String word = args[0];
        firstNonRepeatingChar(word);
        return;


    }


    public static void firstNonRepeatingChar(String word) {


        int length = word.length();
        HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();

        Character current;
        for (int i=0; i< length; i++) {
            current = word.charAt(i);

            if (charMap.containsKey(current)) {
                charMap.put(current,charMap.get(current)+1);    
            } else {
                charMap.put(current,1);
            }
        }


        for (int i=0; i< length; i++) {
            
            current = word.charAt(i);
            if (charMap.get(current) == 1) {
                System.out.println("The first non repeating character is: "+current);
                return;
            }
        }
        System.out.println("All characters were repeating");
        return;

    }


}
