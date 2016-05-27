public class Solution {
    /**
     * @param A: Given an integer array
     * @return: void
     */
    
    private void siftup(int[] A, int i) {
        while (i != 0) {
            int parent = (i - 1) / 2;
            if (A[parent] > A[i]) {
                int temp = A[i];
                A[i] = A[parent];
                A[parent] = temp;
                i = parent;
            } else {
                break;
            }
        }
    }
     
    public void heapify(int[] A) {
        for (int i = 0; i < A.length; i++) {
            siftup(A, i);
        }
    }
}
