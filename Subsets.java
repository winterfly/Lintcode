class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
     
    private void dfs(int[] nums, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> array, int i) {
        res.add(new ArrayList<Integer>(array));
        
        for (int j = i; j < nums.length; j++) {
            array.add(nums[j]);
            dfs(nums, res, array, j + 1);
            array.remove(array.size() - 1);
        }
    } 
    
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        ArrayList<Integer> array = new ArrayList<>();
        dfs(nums, res, array, 0);
        return res;
    }
}
