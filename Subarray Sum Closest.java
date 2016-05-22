class Pair {
    int sum;
    int index;
    Pair(int val, int i) {
        sum = val;
        index = i;
    }
}

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
     
    public int[] subarraySumClosest(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int n = nums.length;
        Pair[] prefixSum = new Pair[n+1];
        prefixSum[0] = new Pair(0, 0);
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += nums[i-1];
            prefixSum[i] = new Pair(sum, i);
        }
        
        Arrays.sort(prefixSum, new Comparator<Pair>() {
           public int compare(Pair p1, Pair p2) {
               return p1.sum - p2.sum;
           } 
        });
        
        int closest = nums[0];
        int res[] = {0, 0};
        for (int i = 1; i <= n; i++) {
            int thisSum = prefixSum[i].sum - prefixSum[i-1].sum; 
            if (Math.abs(thisSum) < Math.abs(closest)) {
                int[] temp = {prefixSum[i].index-1, prefixSum[i-1].index-1};
                Arrays.sort(temp);
                res[0] = temp[0] + 1;
                res[1] = temp[1];
                closest = thisSum;
            }
        }
        
        return res;
    }
}
