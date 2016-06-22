class Solution {
    /**
     * @param A: An integer matrix
     * @return: The index of the peak
     */
    public List<Integer> findPeakII(int[][] A) {
        List<Integer> list = new ArrayList<Integer>();
        
        int left = 0, right = A.length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int col = 0;
            int max = 0;
            for (int j = 0; j < A[mid].length; j++) {
                if (A[mid][j] > max) {
                    max = A[mid][j];
                    col = j;
                }
            }
            if (A[mid-1][col] < A[mid][col] && A[mid+1][col] < A[mid][col]) {
                list.add(mid);
                list.add(col);
                return list;
            } else if (A[mid-1][col] > A[mid][col]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return list;
    }
}
