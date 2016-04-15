class TrieNode {
    HashMap<Character, TrieNode> children;
    boolean isWord;
    TrieNode() {
        children = new HashMap<>();
        isWord = false;
    }
}

public class Solution {
    /**
     * @param board: A list of lists of character
     * @param word: A string
     * @return: A boolean
     */
    
    TrieNode root = new TrieNode();
    private int m, n;
    
    private int[] dx = {1, -1, 0, 0};
    private int[] dy = {0, 0, 1, -1};
    
    private void addWord(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!cur.children.containsKey(c)) {
                cur.children.put(c, new TrieNode());
            }
            cur = cur.children.get(c);
        }
        cur.isWord = true;
    }
    
    private boolean dfs(int i, int j, int index, char[][] board, boolean[][] visited, TrieNode cur) {
        if (i < 0 || i >= m || j < 0 || j >= n) return false;
        if (visited[i][j]) return false;
        visited[i][j] = true;
        char c = board[i][j];
        if (cur.children.containsKey(c)) {
            TrieNode now = cur.children.get(c);
            if (now.isWord) {
                return true;
            } else {
                for (int k = 0; k < 4; k++) {
                    if (dfs(i + dx[k], j + dy[k], index + 1, board, visited, now)) {
                        return true;
                    }
                }
            }
        } 
        visited[i][j] = false;
        return false;
    }
    
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) return true;
        if (board == null || board.length == 0) return false;
        m = board.length;
        if (board[0] == null || board[0].length == 0) return false;
        n = board[0].length;
        
        addWord(word);
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(i, j, 0, board, visited, root)) {
                    return true;
                }
            }
        }
        return false; 
       
    }
}
