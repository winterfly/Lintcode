public class Solution {
    /**
     * @param n: an integer
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int n) {
       
       boolean[] dp = new boolean[n + 1];
       dp[0] = false;
       if (n >= 1) {
           dp[1] = true;
       }
       if (n >= 2) {
           dp[2] = true;
       }
       if (n >= 3) {
           dp[3] = false;
       }
       if (n >= 4) {
           dp[4] = true;
       }
       for (int i = 5; i <= n; i++) {
           dp[i] = !dp[i-1] || !dp[i-2]; 
       }
       return dp[n];
    }
    
}
