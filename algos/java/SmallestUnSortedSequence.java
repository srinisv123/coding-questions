import java.util.Arrays;
class SmallestUnSortedSequence {


    public static void main(String[] args) {

        int[] array = {1,2,4,7,10,11,7,12,6,7,16,18,19};
        smallestUnSortedSequence(array);

    }



    public static void smallestUnSortedSequence(int[] array) {


        int start=0, end=0, maxInRange = -1;


        for(int i=1 ; i< array.length; i++) {

            if (array[i] < array[i-1]) {
            
                if (start ==0) {
                    start = i-1;
                }

                while(start >0 && array[start]>array[i]) {
                    start--;
                }

                end = i;

                maxInRange = maxInRange > array[i-1]? maxInRange : array[i-1];

            } else if (array[i] > array[i-1]){

                if (array[i] < maxInRange) {
                    end = i;
                }
            }


        }


        System.out.println("The range is: " +Arrays.toString(array));
        System.out.println("The min range is: "+start+" to "+end);
        return;




    }



}
