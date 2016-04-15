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
     * @param nodes a array of Directed graph node
     * @return a connected set of a directed graph
     */
     
     
    HashMap<DirectedGraphNode, DirectedGraphNode> parent = new HashMap<>();
    
    public List<List<Integer>> connectedSet2(ArrayList<DirectedGraphNode> nodes) {
        for (DirectedGraphNode node : nodes) {
            parent.put(node, node);
        }
        
        DirectedGraphNode father1, father2;
        for (DirectedGraphNode node : nodes) {
            father1 = find(node);
            for (DirectedGraphNode neighbor : node.neighbors) {
                father2 = find(neighbor);
                if (father1 != father2) {
                    parent.put(father2, father1); // Can not be opposite!
                }
            }
        }
        
        HashMap<DirectedGraphNode, Integer> component = new HashMap<>();
        List<List<Integer>> list = new ArrayList<>();
        int count = 0, index;
        for (DirectedGraphNode node : nodes) {
            DirectedGraphNode father = find(node);
            if (component.containsKey(father)) {
                index = component.get(father);
                list.get(index).add(node.label);
            } else {
                component.put(father, count);
                count++;
                List<Integer> cc = new ArrayList<>();
                cc.add(node.label);
                list.add(cc);
            }
        }
        
        return list;
        
    }
    
    private DirectedGraphNode find(DirectedGraphNode node) {
        DirectedGraphNode father = parent.get(node);
        while (parent.get(father) != father ) {
            father = parent.get(father);
        }
        
        DirectedGraphNode temp;
        while (node != parent.get(node)) {
            temp = parent.get(node);
            parent.put(node, father);
            node = temp;
        }
        
        return father;
        
    }
}
