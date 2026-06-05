class Solution {
    public int rob(int[] nums) {
        /*
        Read and understood Q clearly. This is so imp for DP problems.
        And draw or visualize and wirte down formula 
        So, we need to rob house but IMP is don't rob neighbour house.
        AND we need to rob max amount.
        Two cases: (here n = nums.length)
        1. We can rob last house which is nums[n] and avoid it's neighbhour which is nums[n-1]
                 so, formula will be ( nums[n] + nums[n-2] )
        2. Don't rob last house, means, inlcude " nums[n-1] "
        Formila: Math.max( (nums[i]+dp[n-2]), (dp[i-1]) );
        here we use dp array to store current house amount val
        */

        // edge case
        if(nums.length < 2) return nums[0];

        // need dp array
         int[] dp = new int[nums.length];

         // As for every dp problem,  fill up first 2 values
         dp[0] = nums[0];
         dp[1] = Math.max(nums[1], nums[0]); // here, in Q we need max value

         for(int i =2; i<nums.length;i++){
            dp[i] = Math.max( (dp[i-2] + nums[i]) , (dp[i-1]) );
         }
         return dp[nums.length-1];
    }
}
