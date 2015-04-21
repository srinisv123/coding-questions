class BinarySearchRotated {

    public static void main(String[] args) {




    }


    public void findSmallestElement(int [] array) {

        int start=0, end=array.length-1;
        

        while (start < end) {
            int mid = (start+end)/2;

            if (array[start]<array[mid]


        }


    }




    public static int binarySearchRotated(int [] array, int num) {

        int start=0, end=array.length-1;
        boolean found = false;

        while (start <=end) {
            mid = (start+end)/2;

            if (num ==array[mid]) {
                return mid;
            }

            if (array[start] <= array[mid]) {
                if (num >= array[start] && num < array[mid]) {
                    end = mid-1;
                } else {
                    start = mid+1;
                }
            } else {
                if (num >array[mid] && num <= array[end]) {
                    start = mid+1;
                } else {
                    end = mid-1;
                }
            }
        } 

        return -1;
        


    }

}
