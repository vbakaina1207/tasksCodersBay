package modul3;

import java.util.Random;

import static java.util.Arrays.deepEquals;

public class GameofLife_111 {
    public static void main(String[] args) {
        int k = 10, n = 10;
        int[][] grid = new int[k][n];
        boolean isLife = true;
        Random r = new Random();

        for(int i= 0; i< grid.length; i++){
            for(int j= 0; j< grid[i].length; j++){
                grid[i][j] = r.nextInt(2);
            }
        }
        System.out.println("First Generation");
        printGrid(grid);
        while (isLife) {
            int[][] generationGrid = generation(grid);
            if(deepEquals(grid, generationGrid))
                isLife = false;
            printGrid(generationGrid);
            grid=generationGrid;
        }
    }


    public static int[][] generation(int grid[][]) {
        int k = grid.length;
        int n = grid[0].length;
        int[][] newGrid = new int[k][n];

        for (int l = 0; l < k; l++) {
            for (int m = 0; m < n; m++) {
                int alive = 0;
                for (int i = -1; i <= 1; i++)
                    for (int j = -1; j <= 1; j++)
                        if ((l+i>=0 && l+i<k) && (m+j>=0 && m+j<n))
                            alive += grid[l + i][m + j];
                alive -= grid[l][m];
                if ((grid[l][m] == 1 && alive == 2) || alive == 3) {
                    newGrid[l][m] = 1;
                }

            }
        }
        System.out.println("Next Generation");
        return newGrid;
    }

    public static void  printGrid(int grid[][]){
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[i].length; j++)
            {
                if (grid[i][j] == 0)
                    System.out.printf("\u001B[36m  %2s ",".");
                else
                    System.out.printf("\u001B[34m  %2s ","#");
            }
            System.out.println();
        }
    }
}
