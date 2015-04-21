class FindNonRepeatedNum {

    // 1,1,2
    // 1,2,2
    // 1,1,2,3,3
    // 1,2,2,3,3
    // 1,1,2,2,3
    // 1,1,2,3,3,4,4
    // 1,1,2,2,3,4,4
    // 1,1,2,2,3,3,4,4,5
    // 

    public static void main(String[] args) {
    
        int[] array = {1,1,4};
        System.out.println("The odd one out is: " + nonRepeatedNum(array));
    }



    public static int nonRepeatedNum(int[] array) {

        int start = 0, end = array.length-1;
        while (start < end) {
            int mid = (start+end)/2;
            if (array[mid] == array[mid-1]) {
                if ((mid-start) %2 ==0) {
                    end = mid-2;

                } else {
                    start = mid+1;
                }
            } else {
                if ((mid-start-1) %2 == 0) {
                    end = mid-1;
                } else {
                    start = mid;
                }
            }
        }

        return array[start];
    }
}
