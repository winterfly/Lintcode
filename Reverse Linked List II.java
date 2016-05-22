/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param ListNode head is the head of the linked list 
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m , int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // get the n-1-th node
        ListNode left = dummy;
        for (int i = 0; i < m - 1; i++) {
            if (left == null) {
                return head;
            }
            left = left.next;
        }
        
        ListNode reverseEnd = left.next;
        // reverse from m to n;
        ListNode tail = null;
        ListNode cur = left.next;
        ListNode temp;
        for (int i = 0; i <= n - m; i++) {
            if (cur == null) {
                break;
            }
            temp = cur.next;
            cur.next = tail;
            tail = cur;
            cur = temp;
        }
        left.next = tail;
        reverseEnd.next = cur;
        
        return dummy.next;
    }
}
