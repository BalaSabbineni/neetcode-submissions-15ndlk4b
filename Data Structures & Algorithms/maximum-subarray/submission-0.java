class Solution {
    public int maxSubArray(int[] nums) {
        // we need to take initial maxSum as 1st index to handle -ve values
        // later we update with help of math.max..
        int maxSum = nums[0];
        int curSum =0;

        for(int i=0; i<nums.length; i++) {
            // this is key, we are cheking current sum is > new incoming index value.
            // this will help to filter out any -ve index values.
            curSum = Math.max(nums[i], curSum+nums[i]);
            maxSum = Math.max(curSum, maxSum);
        }
        return maxSum;
        
    }
}
