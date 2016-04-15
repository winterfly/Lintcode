public class Solution {
    /**
     * @param board a 2D board containing 'X' and 'O'
     * @return void
     */
     
    private int m, n;
    private int[] dx = {1, -1, 0, 0};
    private int[] dy = {0, 0, 1, -1};
    private void dfsReplace(char[][] board, char c0, char c1, int i, int j) {
        if (i < 0  || i >= m || j < 0 || j >= n || board[i][j] != c0) {
            return;
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(i*n+j);
        while (!queue.isEmpty()) {
            int index = queue.poll();
            i = index/n;
            j = index%n;
            board[i][j] = c1;
            for (int k = 0; k < 4; k++) {
                int ii = i + dx[k];
                int jj = j + dy[k];
                
                if (ii < 0  || ii >= m || jj < 0 || jj >= n || board[ii][jj] != c0) {
                    continue;
                }
                queue.offer(ii*n+jj);
            }
        }
    } 
    
    public void surroundedRegions(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        m = board.length;
        if (board[0] == null || board[0].length == 0) {
            return;
        }
        n = board[0].length;
        
        // first part
        for (int i = 0; i < m; i++) {
            dfsReplace(board, 'O', '#', i, 0);
            dfsReplace(board, 'O', '#', i, n-1);
        }
        
        for (int j = 1; j < n-1; j++) {
            dfsReplace(board, 'O', '#', 0, j);
            dfsReplace(board, 'O', '#', m-1, j);
        }
        
        // second part
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }

        
        
    }
}
