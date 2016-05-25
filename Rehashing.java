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
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */    
    private int capacity;     
    
    private int hashcode(int key) {
        return (key % capacity + capacity) % capacity;
    }
    public ListNode[] rehashing(ListNode[] hashTable) {
        capacity = 2 * hashTable.length;
        ListNode[] newHashTable = new ListNode[capacity];
        ListNode[] tail = new ListNode[capacity];
        for (int i = 0; i < hashTable.length; i++) {
            ListNode node = hashTable[i];
            while (node != null) {
                ListNode temp = node.next;
                node.next = null;
                int j = hashcode(node.val);
                if (newHashTable[j] == null) {
                    newHashTable[j] = node;
                    tail[j] = node;
                } else {
                    tail[j].next = node;
                    tail[j] = node;
                }
                node = temp;
            }
        }
        
        return newHashTable;
    }
};
