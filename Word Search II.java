class TrieNode {
    HashMap<Character, TrieNode> children;
    boolean isWord;
    String str;
    TrieNode() {
        children = new HashMap<>();
        isWord = false;
        str = "";
    }
}



public class Solution {
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
     
    TrieNode root;
    int n, m;
    
    public Solution() {
        root = new TrieNode();
    }
    
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
        cur.str = word;
    }
    
    private void dfs(char[][] board, ArrayList<String> array, int i, int j, TrieNode cur) {
        if (i < 0 || i >= n || j < 0 || j >= m) return;
        char c = board[i][j];
        board[i][j] = '0';
        if (cur.children.containsKey(c)) {
            if (cur.children.get(c).isWord) {
                String word = cur.children.get(c).str;
                if (!array.contains(word)) {
                    array.add(word);
                }
            }
            cur = cur.children.get(c);
            dfs(board, array, i+1, j, cur);
            dfs(board, array, i-1, j, cur);
            dfs(board, array, i, j+1, cur);
            dfs(board, array, i, j-1, cur);
        }
        board[i][j] = c;
    }
    
    public ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
        ArrayList<String> array = new ArrayList<>();
        
        if (board == null || board.length == 0) return array;
        n = board.length;
        if (board[0] == null || board[0].length == 0) return array;
        m = board[0].length;
        
        for (String word : words) {
            addWord(word);
        }
        
        String str;
        boolean[][] visited = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(board, array, i, j, root);
            }
        }
        
        return array;
    }
}
