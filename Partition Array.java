public class Solution {
	/** 
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    } 
    
    public int partitionArray(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }
	    int left = 0, right = nums.length - 1;
	    while (left < right) {
	        if (nums[left] < k) {
	            left++;
	            if (nums[right] >= k) {
	                right--;
	            }
	        } else if (nums[right] < k) {
	            swap(nums, left, right);
	            left++;
	            right--;
	        } else {
	            right--;
	        }
	    }	   
	    return nums[left] < k ? left+1 : left;
    }
}
