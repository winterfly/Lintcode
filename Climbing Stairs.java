public class Solution {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        if (n <= 1 ) {
            return 1;
        } 
        int a = 0, b = 1, c = a + b;
        for (int i = 2; i <= n; i++) {
            a = b;
            b = c;
            c = a + b;
        }
        
        return c;
    }
}
