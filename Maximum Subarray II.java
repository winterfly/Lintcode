public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        // two arrays: left[i] = largest sum from nums[0] to nums[i], must contain nums[i].
        //             right[i] = largest sum from nums[i] to nums[n-1], must contain nums[i].
        // two global arrays: left[i] = largest sum from nums[0] to nums[i].
        //             right[i] = largest sum from nums[i] to nums[n-1].
        // function: left[i] = max(nums[i], left[i-1] + nums[i]);
        //           leftGlobal[i] = max(leftGlobal[i-1], left[i]);
        //           right[i] = max(nums[i], right[i+1] + nums[i]);
        //           rightGlobal[i] = max(rightGlobal[i+1], right[i]);
        //           dp[i] = left[i] + right[i+1], i = 1, ..., n-2.
        // initialziation: left[0] = nums[0], right[n-1] = nums[n-1];
        
        if (nums == null || nums.size() == 0 ) {
            return 0;
        }
        int n = nums.size();
        int[] left = new int[n];
        int[] right = new int[n];
        int[] leftGlobal = new int[n];
        int[] rightGlobal = new int[n];
        left[0] = nums.get(0);
        leftGlobal[0] = nums.get(0);
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i-1] + nums.get(i), nums.get(i));
            leftGlobal[i] = Math.max(leftGlobal[i-1], left[i]);
        }
        right[n-1] = nums.get(n-1);
        rightGlobal[n-1] = nums.get(n-1);
        for (int i = n-2; i >= 0; i--) {
            right[i] = Math.max(right[i+1] + nums.get(i), nums.get(i));
            rightGlobal[i] = Math.max(rightGlobal[i+1], right[i]);
        }
        
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n-1; i++) {
            res = Math.max(res, leftGlobal[i] + rightGlobal[i+1]);
        }
        return res;
    }
}

