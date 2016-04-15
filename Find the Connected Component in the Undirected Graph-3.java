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
        
        HashMap<UndirectedGraphNode, Integer> CC = new HashMap<>();
        
        int count = 0;
        for (UndirectedGraphNode node : nodes) {
            if (!CC.containsKey(node)) {
                CC.put(node, count);
                Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
                queue.offer(node);
                UndirectedGraphNode cur;
                while (!queue.isEmpty()) {
                    cur = queue.poll();
                    CC.put(cur, count);
                    for (UndirectedGraphNode neighbor : cur.neighbors) {
                        if (!CC.containsKey(neighbor)) {
                            CC.put(neighbor, count);
                            queue.offer(neighbor);
                        }
                    }
                }
                count++;
            }
        }
        
        for (int i = 0; i < count; i++) {
            List<Integer> cc = new ArrayList<>();
            list.add(cc);
        }
        
        for (UndirectedGraphNode node : nodes) {
            if (CC.containsKey(node)) {
                list.get(CC.get(node)).add(node.label);
            } else {
                List<Integer> cc = new ArrayList<>();
                cc.add(node.label);
                list.add(cc);
            }
        }
        return list;
    }
}
