public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
    private void dfs(int[] candidates, int pos, int num, int target, List<Integer> list, List<List<Integer>> res) {
        
        if (num == target) {
            res.add(new ArrayList<>(list));
            return;
        }
        
        if (pos == candidates.length) {
            return;
        }
        
        if (pos != 0 && candidates[pos] == candidates[pos - 1]) {
            return;
        }
        
        int number = candidates[pos];
        int n = (target - num)/number;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                list.add(number);
            }
            dfs(candidates, pos + 1, num + i * number, target, list, res);
            for (int j = 0; j < i; j++) {
                list.remove(list.size() - 1);
            }
        }
        
        
    }
     
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        if (candidates == null || candidates.length == 0) {
            return null;
        }
        Arrays.sort(candidates);
        
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(candidates, 0, 0, target, list, res);
        
        return res;
    }
}
