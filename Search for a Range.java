public class Solution {
    /** 
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        int[] res = {-1, -1};
        if (A.length == 0) return res;
        int left = 0, right = A.length - 1;
        int mid;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (A[mid] == target) {
                right = mid;
            } else if (A[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (A[left] == target) res[0] = left;
        else if (A[right] == target) res[0] = right;
        else return res;
        
        left = 0;
        right = A.length - 1;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (A[mid] == target) {
                left = mid;
            } else if (A[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        if (A[right] == target) res[1] = right;
        else if (A[left] == target) res[1] = left;
        
        return res;
    }
}
