class TrieNode{
    HashMap<Character, TrieNode> children;
    boolean isWord;
    
    TrieNode() {
        children = new HashMap<Character, TrieNode>();
        isWord = false;
    }
}

public class WordDictionary {
    
    TrieNode root = new TrieNode();
    
    HashSet<String> wordSet = new HashSet<>();

    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode cur = root;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            if (!cur.children.containsKey(c)) {
                cur.children.put(c, new TrieNode());
            }
            cur = cur.children.get(c);
        }
        cur.isWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    
    private boolean searchHelper(String word, int index, TrieNode root) {
        if (index == word.length()) return false;
        char c = word.charAt(index);
        if (c == '.') {
            for (Map.Entry<Character, TrieNode> child : root.children.entrySet()) { 
                if (index == word.length() - 1 && child.getValue().isWord) return true;
                if (searchHelper(word, index + 1, child.getValue())) {
                return true;
                }
            }
        } else if (root.children.containsKey(c)) {
            if (index == word.length() - 1 && root.children.get(c).isWord) return true;
            return searchHelper(word, index + 1, root.children.get(c));
        }
        return false;
    }
    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
