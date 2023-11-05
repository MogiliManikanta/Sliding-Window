import java.util.Hashtable;

public class LRUCache {

    // Definition of a doubly-linked list node
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode post;
    }

    // Add a node right after the head
    private void addNode(DLinkedNode node) {
        node.pre = head;
        node.post = head.post;
        head.post.pre = node;
        head.post = node;
    }

    // Remove an existing node from the linked list
    private void removeNode(DLinkedNode node) {
        DLinkedNode pre = node.pre;
        DLinkedNode post = node.post;
        pre.post = post;
        post.pre = pre;
    }

    // Move a certain node in between the head and its original next node
    private void moveToHead(DLinkedNode node) {
        this.removeNode(node);
        this.addNode(node);
    }

    // Pop the current tail (the least recently used node)
    private DLinkedNode popTail() {
        DLinkedNode res = tail.pre;
        this.removeNode(res);
        return res;
    }

    // Hashtable to store key-value pairs for quick access
    private Hashtable<Integer, DLinkedNode> cache = new Hashtable<Integer, DLinkedNode>();
    private int count; // Current number of elements in the cache
    private int capacity; // Maximum capacity of the cache
    private DLinkedNode head, tail; // Dummy head and tail nodes for the doubly-linked list

    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;

        // Initialize dummy head and tail nodes for the doubly-linked list
        head = new DLinkedNode();
        head.pre = null;

        tail = new DLinkedNode();
        tail.post = null;

        head.post = tail;
        tail.pre = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1; // Key not found, should raise an exception here.
        }

        // Move the accessed node to the head to indicate it's the most recently used
        this.moveToHead(node);

        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);

        if (node == null) {
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;

            // Add the new node to the cache and the doubly-linked list
            this.cache.put(key, newNode);
            this.addNode(newNode);

            ++count;

            if (count > capacity) {
                // If the cache capacity is exceeded, remove the least recently used node
                DLinkedNode tail = this.popTail();
                this.cache.remove(tail.key);
                --count;
            }
        } else {
            // If the key already exists in the cache, update its value and move it to the head
            node.value = value;
            this.moveToHead(node);
        }
    }
}