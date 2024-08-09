class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        if (grid.length < 3 || grid[1].length < 3) {
            return 0;
        }
        int count = 0;
        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[i].length - 1; j++) {
                if(isMagicMatrix(grid, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    public boolean isMagicMatrix(int[][] grid, int i, int j) {
        if (grid[i][j] != 5) {
            return false;
        }
        
        int d1Sum = 0;
        int d2Sum = 0;
        for (int z = -1; z < 2; z++) {
            d1Sum += grid[i + z][j + z];
            d2Sum += grid[i + z][j + (z * -1)];
        }
        if (d1Sum != d2Sum) {
            return false;
        }
        int num = 0;
        int rowSum = 0;
        int colSum = 0;
        for (int x = -1; x < 2; x++) {
            rowSum = 0;
            colSum = 0;
            
            for (int y = -1; y < 2; y++) {
                if (num == grid[i + x][j + y]) {
                    return false;
                }
                num = grid[i + x][j + y];
                if (num < 1 || num > 9) {
                    return false;
                }
                rowSum += grid[i + x][j + y];
                colSum += grid[i + y][j + x];
            }
            if (rowSum != colSum || rowSum != d1Sum) {
                return false;
            }
        }
        return true;
    }
}