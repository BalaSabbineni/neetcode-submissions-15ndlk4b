class Solution {
    public int rob(int[] nums) {
        /*
        Same like House robber 1, but this Q is circular way.
        last house is neighbour of 1st house

        we can do it two ways:
        1. Skip last house nd cal max money
        2. Skip first house nd cal max money 

        total_loot = Max(total_skip_first, total_skip_last);
        So, we need 2 arrays; skipLastHouse & skipFirstHouse
        */

        // edge case
        if(nums.length < 2) return nums[0];

        int[] skipLastHouse = new int[nums.length-1];
        int[] skipFirstHouse = new int[nums.length-1];

        // now, we need to fill arrays by skip fist and last house

        for(int i=0;i<nums.length-1;i++){
            // skip first house
            skipFirstHouse[i] = nums[i+1];

            // skipped last house
            skipLastHouse[i] = nums[i];
        }

        // now we need helper function to cal, max from these two arrays
        // and return max of those two
        int lootSkippingLast = robHelper(skipLastHouse);
        int lootSkippingFirst = robHelper(skipFirstHouse);

        return Math.max(lootSkippingLast, lootSkippingFirst);     
    }

    // helper function same as house robber 1 problem
    private int robHelper(int[] arr){
        // this check is for input nums=[0,0].
        // we will get only one element after skipping first and last cases
        if(arr.length < 2) return arr[0];

        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);

        for(int i=2;i<arr.length;i++){
            dp[i] = Math.max( (dp[i-2] + arr[i]) , (dp[i-1]) );
        }

        return dp[arr.length-1];
    }
}
