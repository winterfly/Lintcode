/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    /**
     * @param n an integer
     * @param m an integer
     * @param operators an array of point
     * @return an integer array
     */
    
    private int[] dx = {1, -1, 0, 0};
    private int[] dy = {0, 0, 1, -1};
    
    private HashMap<Integer, Integer> parent;
    private HashSet<Integer> visitedSet;
    
    public Solution() {
        parent = new HashMap<>();
        visitedSet = new HashSet<>();
    }
    
    private int find(int index) {
        int ancestor = parent.get(index);
        while (ancestor != parent.get(ancestor)) {
            ancestor = parent.get(ancestor);
        }
        
        int temp;
        while (index != parent.get(index)) {
            temp = parent.get(index);
            parent.put(index, ancestor);
            index = temp;
        }
        
        return ancestor;
    }
    
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        List<Integer> list = new ArrayList();
        if (operators == null || operators.length == 0) return list;
        int index;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                index = i * m + j;
                parent.put(index, index);
            }
        }
        
        int count = 0;
        int index2;
        for (Point p : operators) {
            index = p.x * m + p.y;
            if (visitedSet.contains(index)) {
                continue;
            }
            visitedSet.add(index);
            int ancestor0 = index;
            count++;
            for (int i = 0; i < 4 ; i++) {
                int x = p.x + dx[i];
                int y = p.y + dy[i];
                if (x >= 0 && x < n && y >= 0 && y < m ) {
                    index2 = x * m + y;
                    if (visitedSet.contains(index2)) {
                        int ancestor = find(index2);
                        if (ancestor != ancestor0) {
                            parent.put(ancestor0, ancestor);
                            ancestor0 = ancestor;
                            count--;
                        }
                    }
                }
            }
            list.add(count);
        } 
        return list;
    }
}
