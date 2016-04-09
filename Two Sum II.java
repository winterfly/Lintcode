public class Solution {
    /**
     * @param nums: an array of integer
     * @param target: an integer
     * @return: an integer
     */
    public int twoSum2(int[] nums, int target) {
        // Write your code here
        int n = nums.length;
        Arrays.sort(nums);
        int left = 0, right = n - 1;
        int res = 0;
        while (left < right) {
            if (nums[left] + nums[right] <= target) {
                left++;
            } else {
                res += right - left;
                right--;
            }
        }
        return res;
    }
}
