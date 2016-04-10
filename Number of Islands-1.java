public class Solution {
    /**
     * @param grid a boolean 2D matrix
     * @return an integer
     */
    public int numIslands(boolean[][] grid) {
        // Write your code here
        if (grid == null) {
            return 0;
        }
        int m = grid.length;
        if (m == 0) {
            return 0;
        }
        if (grid[0] == null) {
            return 0;
        }
        int n = grid[0].length;
        if (n == 0) {
            return 0;
        }
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j]) {
                    count++;
                    dfs(grid, visited, i, j);
                }
            }
        }
        return count;
    }
    private void dfs(boolean[][] grid, boolean[][] visited, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        }
        if (visited[i][j] || !grid[i][j]) {
            return;
        }
        visited[i][j] = true;
        dfs(grid, visited, i - 1, j);
        dfs(grid, visited, i + 1, j);
        dfs(grid, visited, i, j - 1);
        dfs(grid, visited, i, j + 1);
    }
}
