class Solution {
    /**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: a double whose format is *.5 or *.0
     */
    int findKth(int[] A, int A_start, int[] B, int B_start, int k) {
        if (A_start >= A.length) {
            return B[B_start + k - 1];
        } 
        if (B_start >= B.length) {
            return A[A_start + k - 1];
        }
        if (k == 1) {
            return Math.min(A[A_start], B[B_start]);
        }
        
        if (B_start + k / 2 - 1 >= B.length || (A_start + k / 2 - 1 < A.length && A[A_start + k / 2 - 1] < B[B_start + k / 2 - 1])) {
            return findKth(A, A_start + k / 2, B, B_start, k - k / 2);
        } else {
            return findKth(A, A_start, B, B_start + k / 2, k - k / 2);
        }
        
    }
     
     
    public double findMedianSortedArrays(int[] A, int[] B) {
        int n = A.length + B.length;
        if (n % 2 == 0) {
            return 0.5*(findKth(A, 0, B, 0, n / 2) + findKth(A, 0, B, 0, n / 2 + 1));
        } else {
            return findKth(A, 0, B, 0, n / 2 + 1);
        }
    }
}
