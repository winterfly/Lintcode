public class Solution {
    /**
     * @param s: A string
     * @return: A list of lists of string
     */
    
    boolean[][] isPalindrome;
    
    void getIsPalindrome(String s) {
        int n = s.length();
        isPalindrome = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            isPalindrome[i][i] = true;
        }
        for (int i = 0; i < n - 1; i++) {
            isPalindrome[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
        }
        
        for (int l = 2; l < n; l++) {
            for (int i = 0; i + l < n; i++) {
                isPalindrome[i][i + l] =(s.charAt(i) ==  s.charAt(i+l) && isPalindrome[i + 1][i + l - 1]);
            }
        }
    }
    
    private void dfs(List<List<String>> res, List<String> list, String s, int pos) {
        if (pos == s.length()) {
            res.add(new ArrayList<String>(list));
            return;
        }
        for (int i = pos; i < s.length(); i++) {
            if (isPalindrome[pos][i]) {
                list.add(s.substring(pos, i + 1));
                dfs(res, list, s, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
    
    public List<List<String>> partition(String s) {
        
        getIsPalindrome(s);
        
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<String>();
        
        dfs(res, list, s, 0);
        
        return res;
    }
}
