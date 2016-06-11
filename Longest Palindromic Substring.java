public class Solution {
    /**
     * @param s input string
     * @return the longest palindromic substring
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return new String("");
        }
        
        int st = 0, ed = 0;
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            isPalindrome[i][i] = true;
        }
        
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                isPalindrome[i][i+1] = true;
                st = i;
                ed = i + 1;
            }
        } 
        
        for (int l = 2; l < s.length(); l++) {
            for (int i = 0; i + l < s.length(); i++) {
                if (isPalindrome[i + 1][i + l - 1] && s.charAt(i) == s.charAt(i + l)) {
                    isPalindrome[i][i + l] = true;
                    st = i;
                    ed = i + l;
                }
            } 
        }
        
        return s.substring(st, ed+1);
        
    }
}
