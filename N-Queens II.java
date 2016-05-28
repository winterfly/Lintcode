class Solution {
    /**
     * Calculate the total number of distinct N-Queen solutions.
     * @param n: The number of queens.
     * @return: The total number of distinct solutions.
     */
     
    int count;
    
    boolean isValid(ArrayList<Integer> cols, int col) {
        int row = cols.size();
        for (int i = 0; i < row; i++) {
            int j = cols.get(i);
            if (j == col || i + j == row + col || i - j == row - col) {
                return false;
            }
        }
        return true;
    }
    
    void dfs(int n, ArrayList<Integer> cols) {
        if (cols.size() == n) {
            count++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isValid(cols, i)) {
                cols.add(i);
                dfs(n, cols);
                cols.remove(cols.size() - 1);
            }
        }
    }
    
    public int totalNQueens(int n) {
        if (n <= 0) {
            return 0;
        }
        count = 0;
        dfs(n, new ArrayList<Integer>());
        return count;
    }
};

