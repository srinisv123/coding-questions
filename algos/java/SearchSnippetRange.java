class SearchSnippetRange {


    public static void main(String[] args) {

        int[][] matrix = {{1,2,9,20,24,32},
                          {55,56,57,59,53,66},
                          {50,60,70,80,90,99}};


        int[] range = new int[2];
        range = getSearchSnippetRange(matrix);

        System.out.println("The range is: "+range[0]+" to "+range[1]);
        return;

    }


    public static int[] getSearchSnippetRange(int[][] matrix) {

        int rows = matrix.length, cols = matrix[0].length;
        int[] currCol = new int[rows];
        int minDiff = 100000;
        int[] range = new int[2];
        int colMax =0, colMin =0, minRow=0;

        while(true) {
            
            colMax = matrix[0][currCol[0]];
            colMin = matrix[0][currCol[0]];
            for(int i=0; i<rows; i++) {
                if (colMax < matrix[i][currCol[i]]) {
                    colMax = matrix[i][currCol[i]];
                }

                if (colMin > matrix[i][currCol[i]]) {
                    colMin = matrix[i][currCol[i]];
                    minRow = i;
                }
            }

            if (minDiff > (colMax-colMin)) {        
                minDiff = colMax-colMin;
                range[0] = colMin;
                range[1] = colMax;
            }

            currCol[minRow]++;
            if (currCol[minRow] >= cols) {
                break;
            }
        }

        return range;
    }
}
