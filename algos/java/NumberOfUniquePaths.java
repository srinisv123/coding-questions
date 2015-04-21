//A robot is located at the top-left corner of a 52 x 52 grid. The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid. How many possible unique paths are there?

import java.math.BigInteger;
class NumberOfUniquePaths {




    public static void main(String[] args) {

        int rows = Integer.parseInt(args[0]);
        int columns = Integer.parseInt(args[1]);

        System.out.println("No of paths: "+numOfUniquePaths(rows,columns));

        return;

    }


    public static BigInteger numOfUniquePaths(int rows, int columns) {

        BigInteger[][] grid = new BigInteger[rows][columns];
        
        for (int i=0; i< rows; i++) 
            grid[i][columns-1] =new BigInteger("1");

        for (int i=0; i< columns; i++)
            grid[rows-1][i] = new BigInteger("1");


        for (int i = rows-2; i >=0 ; i--) {
            for(int j = columns-2; j>=0; j--) {
                grid[i][j]=grid[i+1][j].add(grid[i][j+1]);
            }
        }

        return grid[0][0];


    }



}
