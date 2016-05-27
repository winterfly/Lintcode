public class Solution {
    /**
     * @param A: Given an integer array
     * @return: void
     */
    
    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    } 
    
    private void siftdown(int[] A, int ind) {
        while (true) {
            int left = 2 * ind + 1;
            int right = 2 * ind + 2;
            if (left >= A.length) {
                break;
            }
            if (right >= A.length) {
                if (A[left] < A[ind]) {
                    swap(A, ind, left);
                    ind = left;
                }
            } else if (A[left] <= A[right] && A[left] < A[ind] ) {
                swap(A, ind, left);
                ind = left;
            } else if (A[right] <= A[left] && A[right] < A[ind]) {
                swap(A, ind, right);
                ind = right;
            }
            if (ind != left && ind != right) {
                break;
            }
        }
    }
    public void heapify(int[] A) {
        for (int i = A.length/2; i >= 0; i--) {
            siftdown(A, i);
        }
    }
}
