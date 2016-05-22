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
        ListNode tail = dummy;
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                tail.next = node1;
                node1 = node1.next;
            } else {
                tail.next = node2;
                node2 = node2.next;
            }
            tail = tail.next;
        }
        if (node1 != null) {
            tail.next = node1;
        } else if (node2 != null) {
            tail.next = node2;
        }
        return dummy.next;
    }
     
    public ListNode mergeKLists(List<ListNode> lists) {  
        if (lists.size() == 0) {
            return null;
        }
        int size = lists.size();
        while (size > 1) {
            int index = 0;
            int count = 0;
            while (index < size) {
                ListNode node = null;
                if (index + 1 < size) {
                    node = merge(lists.get(index), lists.get(index+1));
                } else {
                    node = lists.get(index);
                }
                lists.set(count, node);
                count++;
                index += 2;
            }
            size = count;
        }
        return lists.get(0);
    }
}
