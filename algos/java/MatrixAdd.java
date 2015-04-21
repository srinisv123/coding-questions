class MatrixAdd {


    public static void main(String[] args) {

        int rows = Integer.parseInt(args[0]);
        int cols = Integer.parseInt(args[1]);

        int startRow = Integer.parseInt(args[2]) -1 ;
        int startCol = Integer.parseInt(args[3]) -1 ;
        int endRow = Integer.parseInt(args[4]) -1 ;
        int endCol = Integer.parseInt(args[5]) -1 ;


        int matrix[][] = new int[rows][cols];

         for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                matrix[i][j] = (int)(Math.random()*10);

        System.out.print("\nOriginal matrix: ");
        printMatrix(matrix);


        int preProcessedMatrix[][] = preProcessMatrix(matrix);

        System.out.print("\n\nPreProcessed matrix: ");
        printMatrix(preProcessedMatrix);


        System.out.println("\n\nSum of small matrix: "+
                            matrixAdd(preProcessedMatrix, startRow,
                            startCol, endRow, endCol));

        return; 




    }


    public static void printMatrix(int[][] matrix) {

         for (int i = 0; i < matrix.length; i++) {
            System.out.println("\n");
            for (int j = 0; j < matrix[0].length; j++)
                if (matrix[i][j] <=9)
                    System.out.print("00"+matrix[i][j]+ " ");
                else if (matrix[i][j] <=99)
                    System.out.print("0"+matrix[i][j]+ " ");
                else 
                    System.out.print(matrix[i][j]+ " ");
            
        }

    }

    

    public static int[][] preProcessMatrix(int[][] matrix) {

        int rows = matrix.length;
        int columns = matrix[0].length;

        int preProcessedMatrix[][] = new int[rows][columns];
        int rowSum = 0;
        int upperRectangle = 0;

        for(int row =0; row<matrix.length; row++) {
            rowSum = 0;
            for(int column=0; column<matrix[row].length; column++) {
                rowSum += matrix[row][column];
                if (row ==0) {
                    upperRectangle = 0;
                } else {
                    upperRectangle = preProcessedMatrix[row-1][column];
                }

                preProcessedMatrix[row][column] = rowSum + upperRectangle;
            }

        }

        return preProcessedMatrix;

    }


    public static int matrixAdd(int[][] preProcessedMatrix, int startRow, 
                                int startColumn, int endRow,
                                int endColumn) {

        if (startRow < 0 || endRow >=preProcessedMatrix.length ||
            startColumn <0 || endColumn >= preProcessedMatrix[0].length ||
            startRow > endRow || startColumn > endColumn) {
                return -1;
        }

        int leftRect = 0;
        if (startColumn != 0) 
            leftRect = preProcessedMatrix[endRow][startColumn-1];
            
        int topRect = 0;
        if (startRow !=0) 
            topRect = preProcessedMatrix[startRow-1][endColumn];

        int topLeftRect = 0;
        if( startRow !=0 && startColumn !=0) 
            topLeftRect  = preProcessedMatrix[startRow-1][startColumn-1];

        return (preProcessedMatrix[endRow][endColumn] -
                leftRect - topRect + topLeftRect);
        
    }






}
