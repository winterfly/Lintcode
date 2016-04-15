/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param nodes a array of Undirected graph node
     * @return a connected set of a Undirected graph
     */
    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        List<List<Integer>> list = new ArrayList<>(); 
        if (nodes == null || nodes.size() == 0) return list; 
        
        HashSet<UndirectedGraphNode> visitedSet = new HashSet<>();
        
        for (UndirectedGraphNode node : nodes) {
            if (!visitedSet.contains(node)) {
                visitedSet.add(node);
                List<Integer> cc = new ArrayList<>();
                Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
                queue.offer(node);
                
                UndirectedGraphNode cur;
                while (!queue.isEmpty()) {
                    cur = queue.poll();
                    cc.add(cur.label);
                    for (UndirectedGraphNode neighbor : cur.neighbors) {
                        if (!visitedSet.contains(neighbor)) {
                            visitedSet.add(neighbor);
                            queue.offer(neighbor);
                        }
                    }
                }
                
                Collections.sort(cc); // I need to sort the array to make sure it is in ascending order.
                list.add(cc);
            }
        }
        return list;
    }
}
