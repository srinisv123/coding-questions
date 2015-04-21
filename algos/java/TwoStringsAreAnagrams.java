import java.util.HashMap;
class TwoStringsAreAnagrams {


    // can be improved with just one hash table, by first incrementing and then 
    // decrementing for second string and remove on 0. This way finally hashtable will be null


    public static void main(String[] args) {

        HashMap<Character,Integer> string1Map = new HashMap<Character,Integer>();
        HashMap<Character,Integer> string2Map = new HashMap<Character,Integer>();

        String string1 = args[0];
        String string2 = args[1];

        if(string1.length() != string2.length()) {
            System.out.println("Not anagrams");
            return;
        }

        storeInHash(string1, string1Map);
        storeInHash(string2, string2Map);


        for(char c : string1Map.keySet()) {
            if (string1Map.get(c) != string2Map.get(c)) {
                System.out.println("Not an anagram");
                return;
            }
        }


        System.out.println("Anagram");

    }



    public static void storeInHash(String string, HashMap<Character,Integer> stringMap) {

        for (int i=0; i< string.length() ;i++) {
            char c = string.charAt(i);
            if (stringMap.containsKey(c)) {
                stringMap.put(c,stringMap.get(c)+1);
            } else {
                stringMap.put(c,1);
            }
        }
    }



}
