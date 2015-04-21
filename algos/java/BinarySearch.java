class BinarySearch {


    public static void main (String[] args) {

        int[] array = {3,4,6,8,10,12,13,15,20,25};

        if (binarySearch(array,Integer.parseInt(args[0]))) {
            System.out.println("Iterative Found");
        } else {
            System.out.println("Iterative Not found");
        }

        if (binarySearchRecursive(array,0,array.length-1,Integer.parseInt(args[0]))) {
            System.out.println("Recursive Found");
        } else {
            System.out.println("Recursive Not found");
        }
        return;
        
        

    }


    public static boolean binarySearch(int[] array, int num) {

        int start =0, end = array.length-1;
        boolean found = false;

        if (num < array[0] || num > array[end]) {
            return found;
        }

        while (start<=end) {
            int mid = (start+end)/2;
            if (num< array[mid]) {
                end = mid-1;
            } else if (num > array[mid]) {
                start = mid+1;
            } else {
                found = true;
                break;        
            }

        }

        return found;
    }
    // 0 1 2 3 4  5  6  7  8  9
    //{3,4,6,8,10,12,13,15,20,25};
    public static boolean binarySearchRecursive(int[] array, int start, int end, int num) {

        if (start <0 || end <0 || end <start) {
            return false;
        }

        int mid = (start+end)/2;
        if (num < array[mid]) {
            return binarySearchRecursive(array,start,mid-1,num);
        } else if (num>array[mid]) {
            return binarySearchRecursive(array,mid+1,end,num);
        } else {
            return true;
        }


    }



}
