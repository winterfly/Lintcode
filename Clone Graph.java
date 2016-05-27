/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.offer(node);
        
        while (!queue.isEmpty()) {
            UndirectedGraphNode n = queue.poll();
            map.put(n, new UndirectedGraphNode(n.label));
            
            for (UndirectedGraphNode neighbor : n.neighbors) {
                if (!map.containsKey(neighbor)) {
                    queue.offer(neighbor);
                }
            }
        }
        
        for (UndirectedGraphNode n : map.keySet()) {
            UndirectedGraphNode newNode = map.get(n);
            for (UndirectedGraphNode neighbor : n.neighbors) {
                newNode.neighbors.add(map.get(neighbor));
            }
        }
        
        return map.get(node);
        
    }
}
