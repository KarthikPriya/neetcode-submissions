public class ListNode{
    int key;
    int val;
    ListNode prev;
    ListNode next;
    ListNode(int key, int val, ListNode prev, ListNode next)
    {
        this.key = key;
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
}
class LRUCache {
        
    ListNode head = null;
    ListNode tail = null;
    HashMap<Integer, ListNode> map = new HashMap<>();
    int capacity=0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new ListNode(-1,-1,null,tail);
        tail = new ListNode(-1,-1,head, null);
        head.next = tail;
    }

    public void addToHead(ListNode node)
    {
        ListNode temp = head.next;
        head.next = node;
        node.prev = head;
        node.next = temp;
        temp.prev = node;
    }

    public ListNode removeFromTail()
    {
        if(tail.prev == head)
        {
            return null;
        }
            ListNode temp = tail.prev;
            ListNode node = temp.prev;
            
            node.next=tail;
            tail.prev = node;

            temp.prev = null;
            temp.next = null;
        return temp;
    }

    public void removeNode(ListNode node)
    {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
            return -1;
        int val = map.get(key).val;
        ListNode temp = map.get(key);
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        addToHead(temp);
        return val;
    }
    
    public void put(int key, int value) {
        ListNode node = map.get(key);
        if (node != null) {
            node.val = value;
            removeNode(node);
            addToHead(node);
            map.put(key, node);
            return;
        }
        if (map.size() == capacity) {
            ListNode lru = removeFromTail();
            map.remove(lru.key);
        }
        node = new ListNode(key, value,null,null);
        addToHead(node);
        map.put(key, node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */