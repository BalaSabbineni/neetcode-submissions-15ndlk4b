class LRUCache {
    /* Very importnat question
    * we need to desgin a class for LRU cache.

    * we need a int varibale for capacity

    * Double LinkedList for tracking cache. 
    we keep most recently used in Front of LS and least used in end of LS.

    * HashMap for searching which is O(1) time.
    */

    private int capacity;
    private HashMap<Integer, LinkedListNode> cache;
    // Double Linked List Node.
    private LinkedList<LinkedListNode> lruCacheList;

    // create a class for double linked List
    private class LinkedListNode{
        int key;
        int val;
        LinkedListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }   
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.lruCacheList = new LinkedList<>(); 
    }

    /*
    For get(), First, we need to check HashMap which is cache name varibale. 
    If, Key is there, we need to update LinkedList node to front with this key.
    */
    
    public int get(int key) {
        // check hashmap key exists or not
        if(cache.containsKey(key)) {
            // then get LinkeList respetive of that key
            LinkedListNode  node = cache.get(key);

            // now remove that node from lruCache linkedlist
            lruCacheList.remove(node);
            // add to front. using add first function
            lruCacheList.addFirst(node);

            // return node val
            return node.val;
        } 
        //if no key found, return -1
        return -1;
        
    }

    /*
    Similar to get() operation, 
    if we already have key, remove that form LS and add to front.
    and check capacity, if it's more than capacity, remove last one.
    */
    
    public void put(int key, int value) {
        // first check key is already present or not.
        // If yes, remove it, update value with new one and add to front of LS.
        if(cache.containsKey(key)) {
            LinkedListNode node = cache.get(key);
            
            // remove it from LS
            lruCacheList.remove(node);

            // IMPORTANT, update node value with new value
            node.val = value;

            // add to front
             lruCacheList.addFirst(node);

        } // if ket not present, check for capacity
        else {
            // check size, if it's full
            if(cache.size() >= capacity) {
                // remove last node for lruList and from this we can get key and update cache hashmap
                 LinkedListNode node = lruCacheList.removeLast();
                 // remove cache hashmap cache key by node key
                 cache.remove(node.key);
            }
                 // create new node with input values
                 // add new node to front of linkedlist and hashmap
                  LinkedListNode newNode = new LinkedListNode(key, value);
                  // add front
                  lruCacheList.addFirst(newNode);
                  // add to cache hashMap
                  cache.put(key, newNode);

        }
       
        
    }
}
