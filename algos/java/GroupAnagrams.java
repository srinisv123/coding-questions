//Given a list of words, group all anagrams together.
import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;

class GroupAnagrams {


    public static void main(String[] args) {


        HashMap<String, ArrayList<String>> map = groupAnagrams(args);
        System.out.println(map.toString());


    }


    public static HashMap<String, ArrayList<String>> groupAnagrams(String[] words) {


        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        

        for (String eachWord : words) {
            char[] chars = eachWord.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            } 
            map.get(key).add(eachWord);
        }        

        return map;

    }


}
