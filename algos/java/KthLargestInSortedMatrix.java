class KthLargestInSortedMatrix {


    public static void main(String[] args) {
    
        int[][] matrix =  {{1,3,5,10},
                                        {2,4,6,11},
                                        {8,12,20,30},
                                        {21,32,40,45}};


        int k = Integer.parseInt(args[0]);

        System.out.println("Kth largest element: "+ kthLargestElement(matrix,k));
        return;

    }



    public static int kthLargestElement(int[][] matrix, int k) {
        int rows = matrix.length, cols = matrix[0].length;
        int[] currentCols = new int[rows];
        for (int i=0; i< rows;i++)  
            currentCols[i] = cols-1;
        int currentMax=matrix[0][0]; 
        for (int j=0; j<k; j++) {
            int maxRow = 0; 
            currentMax = matrix[0][0];
            for(int i=0; i<rows; i++) {

                if (currentCols[i] >=0 && (matrix[i][currentCols[i]] > currentMax)) {
                    currentMax = matrix[i][currentCols[i]];
                    maxRow = i;
                }

            }
            currentCols[maxRow]--;
        }

        return currentMax;
    }


} 
