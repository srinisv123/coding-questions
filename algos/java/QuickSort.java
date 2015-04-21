import java.util.Random;
import java.util.Arrays;
class QuickSort {


    public static void main(String[] args) {

        int arrayLen = Integer.parseInt(args[0]);
        int[] numbers = new int[arrayLen];
        for(int i=0;i<arrayLen;i++) {
            numbers[i] = Integer.parseInt(args[i+1]);
        }

        System.out.println("Before Sorting:");
        System.out.println(Arrays.toString(numbers));
        quickSort(numbers, 0, arrayLen-1);
        System.out.println("After Sorting:");
        System.out.println(Arrays.toString(numbers));
        




    }


    public static void quickSort(int[] numbers, int start, int end) {


       if(start<end) {

            // get a random pivot
            //Random r = new Random();
            //int pivot = r.nextInt(end-start) + start;
            int pivot = end;

            // get the point of partition
            int newPivot = partition(numbers, start, end, pivot);

            //quick sort the two subarrays
            quickSort(numbers, start, pivot-1);
            quickSort(numbers, pivot+1,end);

        }

        return; 
    }


    public static int partition(int[] numbers, int start, int end, int pivot) {

        // move the pivot to the last element
        int pivotVal = numbers[pivot];
        numbers[pivot] = numbers[end];
        int leftIndex = start;
        for (int i=start; i<end-1; i++) {
            if (numbers[i] <= pivotVal) {
                int temp = numbers[i];
                numbers[i] = numbers[leftIndex];
                numbers[leftIndex] = temp;
                leftIndex++;
            }
        }

        numbers[end] = numbers[leftIndex]; 
        numbers[leftIndex] = pivotVal;

        return leftIndex;

    }

}
