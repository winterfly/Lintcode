public class Solution {
    /**
     * @param board a 2D board containing 'X' and 'O'
     * @return void
     */
     
    Queue<Integer> queue = new LinkedList<Integer>();
    
    private int m, n;
    private int[] dx = {1, -1, 0, 0};
    private int[] dy = {0, 0, 1, -1};
    
    
    void enqueue(int i, int j, char[][] board) {
        if (i >= 0 && i < m && j >= 0 && j < n && board[i][j] == 'O') {
            queue.offer(i*n+j);
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
            enqueue(i, 0, board);
            enqueue(i, n-1, board);
        }
        
        for (int j = 1; j < n-1; j++) {
            enqueue(0, j, board);
            enqueue(m-1, j, board);
        }
        
        while (!queue.isEmpty()) {
            int index = queue.poll();
            int i = index/n;
            int j = index%n;
            board[i][j] = '#';
            for (int k = 0; k < 4; k++) {
                enqueue(i + dx[k], j + dy[k], board);
            }
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
