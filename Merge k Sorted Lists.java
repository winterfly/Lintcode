/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
     
    private Comparator<ListNode> ListNodeComparator = new Comparator<ListNode>() {
        public int compare(ListNode left, ListNode right) {
            if (left == null) {
                return 1;
            }
            if (right == null) {
                return -1;
            }
            return left.val - right.val;
        }
    };
    
    public ListNode mergeKLists(List<ListNode> lists) {  
        int k = lists.size();
        if (k <= 0) {
            return null;
        }
        
        Queue<ListNode> heap = new PriorityQueue<ListNode>(k, ListNodeComparator);
        
        ListNode dummy = new ListNode(0);
        for (int i = 0; i < k; i++) {
            if (lists.get(i) != null) {
                heap.add(lists.get(i));
            }
        }
        
        ListNode pre = dummy;
        while (!heap.isEmpty()) {
            ListNode temp = heap.poll();
            pre.next = temp;
            pre = temp;
            if (temp.next != null) {
                heap.add(temp.next);
            }
        }
        
        return dummy.next;
        
    }
}
