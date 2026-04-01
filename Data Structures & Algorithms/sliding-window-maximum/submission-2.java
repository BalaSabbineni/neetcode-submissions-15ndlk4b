class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k+1];

        Deque<Integer> dq = new LinkedList<>();

        for(int i =0; i < nums.length; i++) {


        // first we need to check deque is nor empty and not out of current window
        while(!dq.isEmpty() && dq.peekFirst() < i - k+1) {
            dq.pollFirst();
        }

        // we need remove smaller elements in current window 
        // if existing element in dq is less than new ith element.

        while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
             dq.pollLast();
        }

        dq.offerLast(i);

        if(i >= k- 1) { // checking  window
            result[i-k+1] = nums[dq.peekFirst()];
        }


        }
        return result;
    }
}
