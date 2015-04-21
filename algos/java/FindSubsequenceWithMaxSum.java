class FindSubSequenceWithMaxSum {


    public static void main(String[] args) {

        int[] numbers = {2,3,-5,6,25,-1,4,-24,9,11};
        System.out.println("Max sum is: "+ maxSubsequence(numbers));


    }


    public static int maxSubsequence(int[] array) {

        int sum=0, currSum=0, maxSum=0;

        for (int i=0;i<array.length; i++) {
    
            if (currSum+array[i] <= 0) {
                sum=0;
                continue;
            }
            sum=sum+array[i];
            if (maxSum<sum) maxSum =sum;
        }

        return maxSum;

    }


}
