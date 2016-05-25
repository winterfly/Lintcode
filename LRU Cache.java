public class Solution {
    private class Node {
        int key;
        int value;
        Node prev = null;
        Node next = null;
        Node(int k, int v) {
            key = k;
            value = v;
        }
    }
    
    int capacity;
    HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    Node head = null;
    Node tail = null;

    // @param capacity, an integer
    public Solution(int capacity) {
        this.capacity = capacity;
    }

    private void remove(Node n) {
        if (n == head) {
            head = head.next;
        } else {
            n.prev.next = n.next;
        }
        if (n == tail) {
            tail = tail.prev;
        } else {
            n.next.prev = n.prev;
        }
        n.prev = null;
        n.next = null;
    }
    
    private void addTail(Node n) {
        if (tail == null) {
            head = n;
            tail = n;
        } else {
            tail.next = n;
            n.prev = tail;
            tail = n;
        }
    }
    
    // @return an integer
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node n = map.get(key);
        remove(n);
        addTail(n);
        return n.value;
    }

    private void removeHead() {
        if (head.next == null) {
            head = null;
            tail = null;
        } else {
            head.next.prev = null;
            head = head.next;
        }
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            n.value = value;
            remove(n);
            addTail(n);
        } else {
            if (map.size() == capacity) {
                map.remove(head.key);
                removeHead();
            }
            Node n = new Node(key, value);
            map.put(key, n);
            addTail(n);
        }
    }
}
