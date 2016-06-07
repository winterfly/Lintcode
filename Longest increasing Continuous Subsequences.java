public class Solution {
    /**
     * @param A an array of Integer
     * @return  an integer
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int length = 1;
        int max = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i-1]) {
                length++;
                max = Math.max(length, max);
            } else {
                length = 1;
            }
        }
        
        length = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i-1]) {
                length++;
                max = Math.max(length, max);
            } else {
                length = 1;
            }
        }
        
        return max;
    }
}
