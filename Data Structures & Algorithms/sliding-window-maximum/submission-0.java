class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // brute force approach
         int max = 0;
        int[] result = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length - k + 1; i++) {
            max = nums[i];
            System.out.println("i.......: " + nums[i]);

            for (int j = i + 1; j < i + k; j++) {
                System.out.println("j: " + nums[j]);
                max = Math.max(max, nums[j]);
            }
            result[i] = max;
        }

        return result;
    }
}
