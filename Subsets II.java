class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
     
    private void dfs(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> array, ArrayList<Integer> S, int pos) {
        res.add(new ArrayList<>(array));
        for (int i = pos; i < S.size(); i++) {
            if (i != pos && S.get(i) == S.get(i-1) ) {
                continue;
            }
            array.add(S.get(i));
            dfs(res, array, S, i+1);
            array.remove(array.size()-1);
        }
    }
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) { 
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (S == null || S.size() == 0) {
            return res;
        }
        
        Collections.sort(S);
        ArrayList<Integer> array = new ArrayList<>();
        dfs(res, array, S, 0);
        return res;
    }
}
