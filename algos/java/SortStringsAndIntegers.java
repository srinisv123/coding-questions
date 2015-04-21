import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.NumberFormatException;
import java.util.ArrayList;
import java.util.Collections;

class SortStringsAndIntegers {

    public static void main(String[] args) {

        try {
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String str = reader.readLine();

            System.out.println("Sorted output: ");
            System.out.println(sortStringsAndIntegers(str));

        } catch(IOException e) {
            System.err.println("Error: " + e);
        }


    }



    public static String sortStringsAndIntegers(String input) {

        ArrayList<String> words = new ArrayList<String>();
        ArrayList<Integer> nums = new ArrayList<Integer>();

        String[] inputWords = input.split(" ");

        Integer num;
        for (int i=0; i<inputWords.length; i++) {
            try {
                num = Integer.parseInt(inputWords[i]);
                nums.add(num); 

            } catch (NumberFormatException e) {
                words.add(inputWords[i]);
            }

        }
        Collections.sort(words);
        Collections.sort(nums);


        String finalString ="";
        int numPos =0, wordPos=0;
        for (int i=0; i<inputWords.length; i++) {
            try {
                num = Integer.parseInt(inputWords[i]);
                finalString += nums.get(numPos++)+" "; 

            } catch (NumberFormatException e) {
                finalString += words.get(wordPos++)+" ";
            }
        }

        return finalString;

    }



}
