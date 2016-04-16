public class Solution {
    /**
     * @param n an integer
     * @param edges a list of undirected edges
     * @return true if it's a valid tree, or false
     */
     
    HashMap<Integer, Integer> parent;
    
    Solution() {
        parent = new HashMap<>();
    } 
    
    
    private int find(int i) {
        int ancestor = i;
        while (ancestor != parent.get(ancestor)) {
            ancestor = parent.get(ancestor);
        }
        int temp;
        while (i != parent.get(i)) {
            temp = parent.get(i);
            parent.put(i, ancestor);
            i = temp;
        }
        return ancestor;
    }
    public boolean validTree(int n, int[][] edges) {
        for (int i = 0; i < n; i++) {
            parent.put(i, i);
        }
        
        for (int i = 0; i < edges.length; i++) {
            int ancestor1 = find(edges[i][0]);
            int ancestor2 = find(edges[i][1]);
            if (ancestor1 == ancestor2) {
                return false;
            } else {
                parent.put(ancestor2, ancestor1);
            }
        }
        
        int ancestor = find(0);
        for (int i = 1; i < n; i++) {
            if (find(i) != ancestor) {
                return false;
            }
        }
        
        return true;
        
    }
}
