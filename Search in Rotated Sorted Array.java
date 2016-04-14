public class Solution {
    /** 
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */
    public int search(int[] A, int target) {
        if (A.length == 0) {
            return -1;
        }
        int left = 0, right = A.length - 1;
        int mid;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (A[mid] == target) {
                return mid;
            }
            if (A[mid] < target) {
                if (A[left] <= A[mid]) {
                    left = mid + 1;
                } else {
                    if (A[right] >= target) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            } else {
                if (A[right] >= A[mid]) {
                    right = mid - 1;
                } else {
                    if (A[left] <= target) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
            }
        }
        
        if (A[left] == target) {
            return left;
        }
        if (A[right] == target) {
            return right;
        }
        return -1;
    }
}
