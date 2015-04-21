import java.util.HashMap;
class RemoveSpecifiedChars {


    public static void main (String[] args) {


       String sentence = args[0];
       String blackList = args[1];

        System.out.println(removeSpecifiedChars(sentence, blackList));
        return; 

    }

    public static StringBuffer removeSpecifiedChars(String sentence, String blackList) {

        HashMap<Character,Integer> blackListMap = new HashMap<Character,Integer>();
        
        int length = blackList.length();
        for (int i=0; i<length; i++) {
            blackListMap.put(blackList.charAt(i), 1);
        }


        StringBuffer finalValue = new StringBuffer();
        length = sentence.length();
        for (int i=0; i<length; i++) {
            if (!blackListMap.containsKey(sentence.charAt(i))) {
                finalValue.append(sentence.charAt(i));
            }
        }

        return finalValue;


    }

}
