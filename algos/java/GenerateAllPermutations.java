import java.util.HashSet;
import java.util.Arrays;
class GenerateAllPermutations {


    public static void main(String[] args) {

        int[] array = {1,2,3};

        int[] out = new int[array.length];
        HashSet<Integer> blacklist = new HashSet<Integer>();

        generateAllPermutations(array,0,out,blacklist);

        return;



    }


    public static void generateAllPermutations(int[] array, int start, int[] out, HashSet<Integer> blacklist){

        if (start >= array.length) {
            System.out.println(Arrays.toString(out));
            return;
        }
        for (int i=0; i< array.length; i++ ) {
            
            if (blacklist.contains(array[i])) {
                continue;
            }
            out[start] = array[i];
            blacklist.add(array[i]);
            generateAllPermutations(array, start+1, out, blacklist);
            blacklist.remove(array[i]);
        }

    }




}
