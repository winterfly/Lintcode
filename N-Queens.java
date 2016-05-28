class Solution {
    /**
     * Get all distinct N-Queen solutions
     * @param n: The number of queens
     * @return: All distinct solutions
     * For example, A string '...Q' shows a queen on forth position
     */

    ArrayList<String> drawBoard(ArrayList<Integer> cols) {
        ArrayList<String> board = new ArrayList<String>();
        int n = cols.size();
        for (int i = 0; i < n; i++) {
            String str = "";
            for (int j = 0; j < n; j++) {
                if (j == cols.get(i)) {
                    str += "Q";
                } else {
                    str += ".";
                }
            }
            board.add(str);
        }
        return board;
    }


    boolean isValid(ArrayList<Integer> cols, int col) {
        int row = cols.size();
        for (int preRow = 0; preRow < row; preRow++) {
            int preCol = cols.get(preRow);
            if (preCol == col) {
                return false;
            }
            if (preCol + preRow  == col + row) {
                return false;
            }
            if (preCol - preRow == col - row) {
                return false;
            }
        }
        return true;
    }

    void dfs(int n, ArrayList<Integer> cols, ArrayList<ArrayList<String>> res) {
        if (cols.size() == n) {
            res.add(drawBoard(cols));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(cols, col)) {
                cols.add(col);
                dfs(n, cols, res);
                cols.remove(cols.size() - 1);
            }
        }
    }

    ArrayList<ArrayList<String>> solveNQueens(int n) {
        if (n <= 0) {
            return null;
        }
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        ArrayList<Integer> cols = new ArrayList<>();
        dfs(n, cols, res);
        return res;
    }
};
