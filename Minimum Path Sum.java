public class Solution {
    /**
     * @param grid: a list of lists of integers.
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int m = grid.length;
        if (grid[0] == null || grid[0].length == 0) return 0;
        int n = grid[0].length;
        
        int[][] dpSum = new int[m][n];
        dpSum[0][0] = grid[0][0];
        for (int j = 1; j < n; j++) {
            dpSum[0][j] = dpSum[0][j-1] + grid[0][j];
        }
        for (int i = 1; i < m; i++) {
            dpSum[i][0] = dpSum[i-1][0] + grid[i][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dpSum[i][j] = Math.min(dpSum[i-1][j], dpSum[i][j-1]) + grid[i][j];
            }
        }
        return dpSum[m-1][n-1];
    }
}
