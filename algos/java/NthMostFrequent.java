import java.util.ArrayList;
import java.util.TreeSet;
import java.util.HashMap;

class NthMostFrequent {

    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        
        ArrayList<String> words = new ArrayList<String>();
        for (int i=1; i<args.length; i++)
            words.add(args[i]);

        words = nthMostFrequentWord(words,n);

        System.out.println("Nth most freq words are: ");
        for (String word: words) {
            System.out.print(word+" ");
        }

        System.out.println("\n");

        return;


    }


    public static ArrayList<String> nthMostFrequentWord(ArrayList<String> words, int n) {


        HashMap<String,Integer> frequencyTable = new HashMap<String,Integer>();
        for(String word : words) {
            if (frequencyTable.containsKey(word)) {
                frequencyTable.put(word,(frequencyTable.get(word)+1));
            } else {
                frequencyTable.put(word,1);
            }
        }


        // form a set of the words
        TreeSet<Integer> setOfNumbers = new TreeSet<Integer>();
        for (Integer frequencies : frequencyTable.values()) {
            setOfNumbers.add(frequencies);
        }

        // or alternatively can do
        //setOfNumbers.addAll(frequencyTable.values(); 

        ArrayList<String> finalSet = new ArrayList<String>();
        // check for the nth most freq word
        if (setOfNumbers.size() >= n) {
            Integer nthHighestFreq = new Integer(0);
            for (int i=0; i<n; i++)         
                nthHighestFreq = setOfNumbers.pollLast();

            // now go back to the hash and get the nth most freq word
            for (String word : frequencyTable.keySet()) {
                if (frequencyTable.get(word) == nthHighestFreq)
                    finalSet.add(word);
            }
        } 
        
        return finalSet;

    }


}
