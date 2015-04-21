//Given an array of strings that have all items occuring even number of times and only one occuring odd number of times. Find the odd one
import java.util.HashSet;
import java.util.Iterator;

class AllEvenStringsOneOdd {


    public static void main(String[] args) {

       System.out.println(oddString(args)); 

    }


    public static String oddString(String[] words) {

        HashSet<String> set = new HashSet<String>();
        for (String word : words) {
            if (set.contains(word)) {
                set.remove(word);
            } else {
                set.add(word);
            }
        }

        Iterator itr = set.iterator();
        if (itr.hasNext()) {
            return (String)itr.next();
        } else {
            return null;
        }


    }



}
