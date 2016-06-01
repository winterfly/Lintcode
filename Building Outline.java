public class Solution {
    /**
     * @param buildings: A list of lists of integers
     * @return: Find the outline of those buildings
     */
    class Edge {
        int pos;
        int height;
        boolean isStart;
        Edge(int p, int h, boolean s) {
            pos = p;
            height = h;
            isStart = s;
        }
    }
     
    public ArrayList<ArrayList<Integer>> buildingOutline(int[][] buildings) {
        ArrayList<Edge> edges = new ArrayList<Edge>();
        
        for (int[] building : buildings) {
            edges.add(new Edge(building[0], building[2], true));
            edges.add(new Edge(building[1], building[2], false));
        }
        
        Collections.sort(edges, new Comparator<Edge>() {
            public int compare(Edge e1, Edge e2) {
                if (e1.pos != e2.pos) {
                    return e1.pos - e2.pos;
                } else if (e1.isStart && e2.isStart) {
                    return e2.height - e1.height;
                } else if (!e1.isStart && !e2.isStart) {
                    return e1.height - e2.height;
                } else {
                    return e1.isStart ? -1 : 1;
                }
            }
        });
        
        
        PriorityQueue<Integer> queue = new PriorityQueue<>(2, Collections.reverseOrder());
        
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (Edge edge : edges) {
            if (edge.isStart) {
                if (queue.isEmpty() || edge.height > queue.peek()) {
                    list.add(new ArrayList<Integer>(Arrays.asList(edge.pos, edge.height)));
                }
                queue.offer(edge.height);
            } else {
                queue.remove(edge.height);
                if (queue.isEmpty()) {
                    list.add(new ArrayList<Integer>(Arrays.asList(edge.pos, 0)));
                } else if (edge.height > queue.peek()) {
                    list.add(new ArrayList<Integer>(Arrays.asList(edge.pos, queue.peek())));
                }
            }
            
        }
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (list.size() == 0) {
            return result;
        }
        
        int xStart = list.get(0).get(0);
        int height = list.get(0).get(1);
        for (int i = 1; i < list.size(); i++) {
            int xEnd = list.get(i).get(0);
            int newHeight = list.get(i).get(1);
            if (height != 0) {
                result.add(new ArrayList<Integer>(Arrays.asList(xStart, xEnd, height)));
            }
            xStart = xEnd;
            height = newHeight;
        }
        
        return result;
        
    }
}
