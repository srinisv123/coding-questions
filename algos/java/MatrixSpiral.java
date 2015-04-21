class MatrixSpiral {

    public static void main(String[] args) {

        int rows = Integer.parseInt(args[0]);
        int cols = Integer.parseInt(args[1]);

        int matrix[][] = new int[rows][cols];

         for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                matrix[i][j] = (int)(Math.random()*10);

        System.out.print("\nOriginal matrix: ");
        printMatrix(matrix);


        System.out.println("\n\nSpiral printing: ");
        matrixSpirally(matrix);

        return; 




    }


    public static void printMatrix(int[][] matrix) {

         for (int i = 0; i < matrix.length; i++) {
            System.out.println("\n");
            for (int j = 0; j < matrix[0].length; j++)
                    System.out.print(matrix[i][j]+ " ");
            
        }

    }



    public static void matrixSpirally(int[][]matrix) {

        int endRow = matrix.length-1;
        int endCol = matrix[0].length-1;
    
        int startRow = 0, startCol =0;

        while(true) {        

            for (int i= startCol; i<=endCol; i++) {        
                System.out.print(matrix[startRow][i]+" ");
            } 

            for (int i=startRow+1; i<= endRow; i++) {
                System.out.print(matrix[i][endCol]+" ");
            }

            if (startRow != endRow) {
                for (int i=endCol-1; i>= startCol; i--) {
                    System.out.print(matrix[endRow][i]+" ");
                }
            }

            if (startCol != endCol) {
                for (int i=endRow-1; i> startRow; i--) {
                    System.out.print(matrix[i][startCol]+" ");
                }
            }

            startRow++;
            startCol++;
            endRow--;
            endCol--;

            if ((startRow > endRow) || (startCol > endCol)) 
                break;

        }

        System.out.println("\n");

        return;

        
    }

}
