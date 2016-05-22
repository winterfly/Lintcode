class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        int len = nums.length;
        int n0 = 0;
        int n1 = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                n0++;
            } else if (nums[i] == 1) {
                n1++;
            }
        }
        for (int i = 0; i < n0; i++) {
            nums[i] = 0;
        }
        for (int i = n0; i < n0 + n1; i++) {
            nums[i] = 1;
        }
        for (int i = n0 + n1; i < len; i++) {
            nums[i] = 2;
        }
    }
}
