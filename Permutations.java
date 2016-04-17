class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
     
    boolean[] visited;
    private void dfs(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> array, ArrayList<Integer> nums, int pos) {
        if (array.size() == nums.size()) {
            res.add(new ArrayList<>(array));
            return;
        }
        for (int i = 0; i < nums.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                array.add(nums.get(i));
                dfs(res, array, nums, i + 1);
                array.remove(array.size() - 1);
                visited[i] = false;
            }
        }
    }
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (nums == null || nums.size() == 0) {
            return res;
        }
        visited = new boolean[nums.size()];
        ArrayList<Integer> array = new ArrayList<>();
        dfs(res, array, nums, 0);
        return res;
    }
}
