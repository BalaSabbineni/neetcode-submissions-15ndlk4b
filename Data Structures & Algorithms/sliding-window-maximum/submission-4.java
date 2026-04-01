class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> dq = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {

            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }
             System.out.println("index: " + (i - k + 1));

            while (!dq.isEmpty() && dq.peekFirst() < i - k + 1) {
                System.out.println("window: "+dq.peekFirst());
                dq.pollFirst();
            }

            dq.offerLast(i);
            if (i >= k - 1) {
                result[i - k + 1] = nums[dq.peekFirst()];
            }

        }
        return result;
    }
}
