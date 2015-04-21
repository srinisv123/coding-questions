class RotateMatrix {

    public static void main(String[] args) {
        int len = Integer.parseInt(args[0]);

        int matrix[][] = new int[len][len];

         for (int i = 0; i < len; i++)
            for (int j = 0; j < len; j++)
                matrix[i][j] = (int)(Math.random()*10);

        System.out.print("\nOriginal matrix: ");
        printMatrix(matrix);


        System.out.println("\n\nRotated matrix printing: ");
        matrix = rotateMatrix(matrix);
        printMatrix(matrix);

        System.out.println("\n");

        return; 




    }


    public static void printMatrix(int[][] matrix) {

         for (int i = 0; i < matrix.length; i++) {
            System.out.println("\n");
            for (int j = 0; j < matrix[0].length; j++)
                    System.out.print(matrix[i][j]+ " ");
            
        }

    }


    public static int[][] rotateMatrix(int[][] matrix) {
        int length = matrix.length;


        for (int currentLength = length; currentLength > 1; currentLength = currentLength-2) {
            int start = (length-currentLength)/2;
            int end = (length - 1) - start;

            for (int i=start; i<end; i++) {
                int temp = matrix[i][start];
                matrix[i][start] = matrix[start][i];

                matrix[end][end-i] = temp[0];

                matrix[end-i][start] = temp[1];

                matrix[start][i] = temp[0];

                
                
            }
        }

       return matrix;

    }


}
