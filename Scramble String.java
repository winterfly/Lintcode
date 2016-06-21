public class Solution {
    /**
     * @param s1 A string
     * @param s2 Another string
     * @return whether s2 is a scrambled string of s1
     */
    
    boolean[][][] dp;
    boolean[][][] flag;
    int n;
    
    boolean search(int left1, int left2, int len, String s1, String s2) {
        if (len <= 0) {
            return true;
        }
        
        if (flag[left1][left2][len]) {
            return dp[left1][left2][len];
        }
        
        int len1 = len / 2;
        int len2 = len - len1;
        
        flag[left1][left2][len] = true;
        
        if (len == 1) {
            dp[left1][left2][len] = s1.charAt(left1) == s2.charAt(left2);
        } else {
            boolean partition1 = search(left1, left2, len1, s1, s2) && search(left1 + len1, left2 + len1, len2, s1, s2);
            boolean partition2 = search(left1, left2 + len2, len1, s1, s2) && search(left1 + len1, left2, len2, s1, s2);
            
            dp[left1][left2][len] =  partition1 || partition2;
            
            if (!dp[left1][left2][len] && len1 != len2) {
                boolean partition3 = search(left1, left2, len2, s1, s2) && search(left1 + len2, left2 + len2, len1, s1, s2);
                boolean partition4 = search(left1, left2 + len1, len2, s1, s2) && search(left1 + len2, left2, len1, s1, s2);
                dp[left1][left2][len] = partition3 || partition4;
            }
        }
        
        return dp[left1][left2][len];
    }
    
    public boolean isScramble(String s1, String s2) {
        if (s1 == null && s2 == null) {
            return true;
        }
        
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        
        n = s1.length();
        dp = new boolean[n][n][n+1];
        flag = new boolean[n][n][n+1];
        
        return search(0, 0, n, s1, s2);
        
    }
}
