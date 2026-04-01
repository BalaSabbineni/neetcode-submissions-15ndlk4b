class KthLargest {
    int k;
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    public KthLargest(int k, int[] nums) {
        this.k=k;
        for(int n:nums){
            add(n);
        }
        
    }
    
    public int add(int val) {
        pq.add(val);
        
        while(pq.size() > k){
            pq.poll();
        }
        return pq.peek();
    }
}
