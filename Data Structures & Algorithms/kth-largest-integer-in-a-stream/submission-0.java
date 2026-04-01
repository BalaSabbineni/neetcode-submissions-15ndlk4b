class KthLargest {
    // we can use brute force approach and sorting but the time complexity is 
    // O(n2) and n(log n) for sort

    // we have a Heap DS and PriorityQueue ADT which can slove our problem
    // we need to use minHeap and this behaves like this
    // if we list like [3,2,1,4,6];
    /*
    If we add elements to minHeap, 
    lowest val elements, will have high priority and stores on top og heap
    after adding all elements, order is [1,2,3,4,6]
    */

    private int k;
    private PriorityQueue<Integer> minHeap;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();

        // add elements in below add() method with our logic 
        for(int i : nums) {
            add(i);
        }  
    }
    
    public int add(int val) {
        // we need to find kth largerst element, 
        // so, we need to add elements upto k size and then check val

        if(minHeap.size() < k) {
            minHeap.offer(val);
        }
        // if we add our k elements checks next element value
        // if new incoming value greater than existing peek element,  remove that and add new one
        else if (val > minHeap.peek()) {
            minHeap.poll();
            minHeap.offer(val);
        }
        // once we don't have any kth higher element, we return below by simply calling peek element
        // how  this works is, higer values stores last in heap and vice versa.
        // we are adding upto only k size, so we can get kth element at top
        return minHeap.peek();
        
    }
}
