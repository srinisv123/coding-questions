import java.util.HashSet;
class SetZerosInMatrix {

    public static void main(String[] args) {

        int[][] matrix = {{1,2,4,5},
                          {0,4,5,0},
                          {5,7,2,4},
                          {4,6,2,4},
                          {0,2,3,6}};        

        System.out.print("\nOriginal matrix: ");
        printMatrix(matrix);

        System.out.print("\nAfter Zeros: ");
        matrix = setZeros(matrix);
        printMatrix(matrix);
        
        System.out.println("\n");

    }

    public static void printMatrix(int[][] matrix) {

         for (int i = 0; i < matrix.length; i++) {
            System.out.println("\n");
            for (int j = 0; j < matrix[0].length; j++)
                    System.out.print(matrix[i][j]+ " ");
            
        }

    }


    public static int[][] setZeros(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        HashSet<Integer> rowSet = new HashSet<Integer>();
        HashSet<Integer> colSet = new HashSet<Integer>();
        for (int i=0 ; i<rows; i++) {

            for (int j=0; j<cols; j++) {
                
                if (matrix[i][j] ==0) {
                    rowSet.add(i);
                    colSet.add(j);
                }
            }

        }

        for (int i =0; i< rows; i++) {
            for (int j=0; j<cols; j++) {
                if (rowSet.contains(i) || colSet.contains(j)) {
                    matrix[i][j] =0;
                }
            }

        }


        return matrix;

    }


}
