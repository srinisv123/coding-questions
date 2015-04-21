// Given a 
import java.util.List;
import java.util.ArrayList;

// Data class for each element in the list
class Data {
    int number;
    String str;

    //Constructor
    public Data (int n, String str) throws IllegalArgumentException{
        if (n <0 || n > 1024) {
            throw new IllegalArgumentException("The number must be between 0 and 1024");
        }
        this.number = n;
        this.str = str;
    }
}


class CountingSortList {


    public static void main(String args[]) {

        List<Data> unsortedListOfObjects = new ArrayList<Data>();
        
        // A Test case adding some sample data
        for (int i=10; i>=0; i--) {
            Data obj = new Data(i,"abc"+i);
            unsortedListOfObjects.add(obj);
            obj = new Data(i,"abcd"+i);
            unsortedListOfObjects.add(obj);


        }

        //print before sort
        printList(unsortedListOfObjects);

        List<Data> sortedList = inPlaceSort(unsortedListOfObjects);

        // print after sort
        printList(sortedList);


        

    }

    // printing function
    public static void printList(List<Data> list) {
        for (Data element : list) {
            System.out.println(element.number + "-->" + element.str);
        }

    }


    public static List<Data> inPlaceSort(List<Data> unsortedListOfObjects) throws IllegalArgumentException{

        // Initial index to keep the number of objects in each
        // number
        int[] index = new int[1024];
        
        // Find the number of objects in each number
        for (Data element : unsortedListOfObjects) {
            // sanity check
            if (element.number <0 || element.number >1024) 
                throw new IllegalArgumentException("The number must be between 0 and 1024");
            index[element.number]++;
        }

        // Keep track of the cumulative count for each object to
        // avoid calculating each time

        // have an array of size 1025 so that i can store 0 in the 0th
        // element
        int[] range = new int[1025];

        // An array to keep track of most recent potition in each 
        // number range
        int[] currPos = new int[1024];
        for(int i=0; i< 1024; i++) {
            range[i+1] = range[i] + index[i];

            // This will be the next position to insert in for the range
            currPos[i] = range[i];
        }


        int i = 0;
        while (i< unsortedListOfObjects.size()) {
            Data current = unsortedListOfObjects.get(i);
            // if the current element is out of range
            if (i < range[current.number] || i > (range[current.number+1]-1) ) {
                // the inner set statement will put the current element in the correct position for it,
                // it returns the object in that location, which we are setting to the current location 
                // in the outer set.
                // Also incrementing currPos by 1 after each swap with the ++
                // This is essentially a swap operation
                unsortedListOfObjects.set(i, unsortedListOfObjects.set(currPos[current.number]++,current));

                // We will not iterate to the next position because now we have to check if the new object
                // introduced here is in the right location
            } else {
                // We will iterate to next position only if the current element is in the right location
                i++; 
            }

        }

        return unsortedListOfObjects;

    }


}
