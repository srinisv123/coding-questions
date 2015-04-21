/* Given 2 integer arrays, print the uncommon integers between
* the two
*
*/
import java.util.Arrays;
import java.util.HashMap;
class UnCommonIntegers {





    public static void main (String[] args) {


        int[] array1 = { 3,5,1,6,31,17,13};
        int[] array2 = { 2,4,1,7,23,12,13};

        unCommonIntegersWithSorting(array1,array2);
        unCommonIntegersWithHashing(array1,array2);
    
    }


    public static void unCommonIntegersWithHashing(int[] array1, int[] array2) {

        int len1 = array1.length, len2 = array2.length;

        HashMap<Integer,Boolean> hash = new HashMap<Integer,Boolean>();

        for(int i : array1) {
            hash.put(i,true);

        }

        for (int i: array2) {
            if (!hash.containsKey(i)) {         
                System.out.print(i+" ");
            } else {
                hash.put(i,false);
            }
        }

        
        for(int i : hash.keySet()) {
            if (hash.get(i)) {
                System.out.print(i+" ");
            }
        }

        System.out.println("\n");

        return; 
            


    }



    public static void unCommonIntegersWithSorting(int[] array1, int[] array2) {


        int len1 = array1.length, len2 =array2.length;
        Arrays.sort(array1);
        Arrays.sort(array2);

        int pos1 =0, pos2=0;


        while (pos1 < len1 && pos2 < len2) {

            if (array1[pos1] < array2[pos2]) {
                System.out.print(array1[pos1++]+" ");
            } else if (array1[pos1] > array2[pos2]) {
                System.out.print(array2[pos2++]+" ");
            } else {
                pos1++; pos2++;
            }
        }


        while (pos1 <len1) {
            System.out.print(array1[pos1++]+" ");
        }

        while (pos2 < len2) {
            System.out.print(array2[pos2++]+" ");
        }

        System.out.println("\n");


        return;

    }

    


}
