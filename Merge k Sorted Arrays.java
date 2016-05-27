public class Solution {
    /**
     * @param arrays k sorted integer arrays
     * @return a sorted array
     */
     
    class Node {
        int val;
        int index;
        int arrayIndex;
        Node(int v, int i, int ai) {
            val = v;
            index = i;
            arrayIndex = ai;
        }
    }
     
    public List<Integer> mergekSortedArrays(int[][] arrays) {
        int k = arrays.length;
        if (k <= 0) {
            return null;
        }
        
        PriorityQueue<Node> queue = new PriorityQueue<Node>(k, new Comparator<Node>() {
                public int compare(Node a, Node b) {
                    return a.val - b.val;
                }
            });
            
        for (int i = 0; i < k; i++) {
            if (arrays[i].length != 0) {
                queue.offer(new Node(arrays[i][0], 0, i));
            }
        }
        
        List<Integer> list = new ArrayList<Integer>();
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            list.add(node.val);
            int i = node.index;
            int ai = node.arrayIndex;
            if (i + 1 < arrays[ai].length) {
                queue.offer(new Node(arrays[ai][i + 1], i + 1, ai));
            }
        }
        
        return list;
        
    }
}
