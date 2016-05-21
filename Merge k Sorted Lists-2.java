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
     
    private ListNode merge(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                pre.next = node1;
                node1 = node1.next;
            } else {
                pre.next = node2;
                node2 = node2.next;
            }
            pre = pre.next;
        }
        
        if (node1 != null) {
            pre.next = node1;
        } else if (node2 != null) {
            pre.next = node2;
        }
        return dummy.next;
    }
     
    private ListNode divideAndConquer(List<ListNode> lists, int st, int ed) {
        if (ed - st < 0) {
            return null;
        } else if (ed - st == 0) {
            return lists.get(st);
        }
        
        int mid = st + (ed - st) / 2;
        ListNode node1 = divideAndConquer(lists, st, mid);
        ListNode node2 = divideAndConquer(lists, mid+1, ed);
        return merge(node1, node2);
    }
     
    public ListNode mergeKLists(List<ListNode> lists) { 
        return divideAndConquer(lists, 0, lists.size()-1);
    }
}
