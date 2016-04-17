class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        int n = nums.length;
        int max = 1 << n;
        for (int i = 0; i < max; i++) {
            ArrayList<Integer> array = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    array.add(nums[j]);
                }
            }
            res.add(array);
        }
        return res;
    }
}
