//Given an array of integers, give back another array where each element would be = product of whole array / value at that point. If there is a 0 at that point, then it shd be the prodict of other rows if they were non-zero
import java.util.Arrays;

class ProductOfElementsOtherThanSelf {



    public static void main(String[] args) {

        int[] array = {1,2,0,3,4,5,0};

        System.out.println("Original: " + Arrays.toString(array));
        int[] result = productOfOtherElementsWithDivision(array);

        System.out.println("Product using division: " + Arrays.toString(result)); 

        int[] result1 = productOfOtherElementsWithoutDivision(array);
        System.out.println("Product without division: " + Arrays.toString(result1)); 


        


    }


    public static int[] productOfOtherElementsWithDivision(int[] array) {

        int len =array.length, product = 1, count =0, hasZero = -1;
        int[] result = new int[len];
        while (count < len) {
            if (array[count] ==0) {
                if (hasZero != -1) {
                    return result;
                } else {
                    hasZero = count;
                }
            } else {
                product *= array[count];
            }
            count++;
        }

        if (hasZero  != -1) {
            result[hasZero] = product;
            return result;
        }
        count =0;
        while (count <len) {
            result[count] = product/array[count];
            count++;

        }
        return result;

    }

    public static int[] productOfOtherElementsWithoutDivision(int[] array) {

        int len = array.length;
        int[] prev = new int[len];
        int[] next = new int[len];
        prev[0]=1;
        for (int i=1; i< len; i++) {
           prev[i] = prev[i-1] * array[i-1];
        }
        next[len-1] = 1;
        for (int i=len-2; i >=0 ; i--) {
            next[i] = next[i+1]*array[i+1];
        }

        for (int i =0; i< len; i++) {
            array[i] = prev[i]*next[i];
        }

        return array;


    }


}



