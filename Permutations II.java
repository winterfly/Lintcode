class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */
     
    private void dfs(ArrayList<Integer> nums, boolean[] visited, ArrayList<Integer> array, ArrayList<ArrayList<Integer>> res) {
        if (array.size() == nums.size()) {
            res.add(new ArrayList<>(array));
            return;
        }
        
        for (int i = 0; i < nums.size(); i++) {
            if (visited[i] || (i != 0 && nums.get(i) == nums.get(i - 1) && !visited[i - 1])) {
                continue;
            }
            visited[i] = true;
            array.add(nums.get(i));
            dfs(nums, visited, array, res);
            array.remove(array.size() - 1);
            visited[i] = false;
        }
    }
     
    public ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) {
        if (nums == null || nums.size() == 0) {
            return null;
        }
        
        Collections.sort(nums);
        boolean[] visited = new boolean[nums.size()];
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> array = new ArrayList<Integer>();
        dfs(nums, visited, array, res);
        return res;
    }
}
