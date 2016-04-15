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

    HashMap<UndirectedGraphNode, UndirectedGraphNode> parent = new HashMap<>();
    
    UndirectedGraphNode find(UndirectedGraphNode node) {
        UndirectedGraphNode ancestor = parent.get(node);
        while (ancestor != parent.get(ancestor)) {
            ancestor = parent.get(ancestor);
        }
        return ancestor;
    }
    
    UndirectedGraphNode compressedFind(UndirectedGraphNode node) {
        UndirectedGraphNode ancestor = parent.get(node);
        while (ancestor != parent.get(ancestor)) {
            ancestor = parent.get(ancestor);
        }
        
        UndirectedGraphNode temp;
        while (node != parent.get(node)) {
            temp = parent.get(node);
            parent.put(node, ancestor);
            node = temp;
        }
        
        return ancestor;
    }
    
    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        for (UndirectedGraphNode node : nodes) {
            parent.put(node, node);
        }
        
        UndirectedGraphNode ancestor1, ancestor2;
        for (UndirectedGraphNode node : nodes) {
            ancestor1 = find(node);
            for (UndirectedGraphNode neighbor : node.neighbors) {
                ancestor2 = find(neighbor);
                if (ancestor1 != ancestor2) {
                    parent.put(ancestor2, ancestor1);
                }
            }
        }
        
        HashMap<UndirectedGraphNode, Integer> component = new HashMap<>();
        UndirectedGraphNode ancestor;
        int count = 0, index;
        List<List<Integer>> list = new ArrayList<>();
        for (UndirectedGraphNode node : nodes) {
            ancestor = compressedFind(node);
            if (component.containsKey(ancestor)) {
                list.get(component.get(ancestor)).add(node.label);
            } else {
                List<Integer> cc = new ArrayList<>();
                cc.add(node.label);
                list.add(cc);
                component.put(ancestor, count);
                count++;
            }
        }
        
        return list;
        
    }
}
