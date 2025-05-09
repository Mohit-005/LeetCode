public class Solution {
    public int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int minimumObstacles(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        // Deque for 0-1 BFS
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{0, 0, 0}); // {row, col, obstacleCount}
        grid[0][0] = -1; // Mark as visited

        while (!dq.isEmpty()) {
            int[] temp = dq.pollFirst();
            int r = temp[0], c = temp[1], obstacle = temp[2];

            // If we've reached the bottom-right corner, return the obstacle count
            if (r == n - 1 && c == m - 1) {
                return obstacle;
            }

            // Explore all 4 directions
            for (int[] d : dir) {
                int row = r + d[0];
                int col = c + d[1];

                if (isValid(row, col, n, m) && grid[row][col] != -1) {
                    if (grid[row][col] == 0) {
                        // Free cell, prioritize by adding to the front
                        dq.addFirst(new int[]{row, col, obstacle});
                    } else {
                        // Obstacle cell, add to the back
                        dq.addLast(new int[]{row, col, obstacle + 1});
                    }
                    // Mark as visited
                    grid[row][col] = -1;
                }
            }
        }

        return -1; // If no path exists (unlikely in a valid grid)
    }

    public boolean isValid(int i, int j, int n, int m) {
        return i >= 0 && j >= 0 && i < n && j < m;
    }
}