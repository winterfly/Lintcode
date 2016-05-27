/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */    
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        if (graph == null) {
            return null;
        }
        
        HashMap<DirectedGraphNode, Integer> map = new HashMap<>();
        
        for (DirectedGraphNode node : graph) {
            if (!map.containsKey(node)) {
                map.put(node, 0);
            }
            
            for (DirectedGraphNode neighbor : node.neighbors) {
                if (map.containsKey(neighbor)) {
                    map.put(neighbor, map.get(neighbor) + 1);
                } else {
                    map.put(neighbor, 1);
                }
            }
        }
        
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        for (DirectedGraphNode node : graph) {
            if (map.get(node) == 0) {
                queue.offer(node);
            }
        }
        
        ArrayList<DirectedGraphNode> list = new ArrayList<>();
        
        while (!queue.isEmpty()) {
            DirectedGraphNode node = queue.poll();
            list.add(node);
            map.remove(node);
            for (DirectedGraphNode neighbor : node.neighbors) {
                if (map.containsKey(neighbor)) {
                    int count = map.get(neighbor) - 1;
                    map.put(neighbor, count);
                    if (count == 0) {
                        queue.offer(neighbor);
                    }
                }
            }
        }
        
        return map.isEmpty() ? list : null;
        
    }
}
