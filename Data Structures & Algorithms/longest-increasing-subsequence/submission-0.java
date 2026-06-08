class Solution {
    public int lengthOfLIS(int[] nums) {
        /*
        we need use DP. need a DP array and track any seq len from that respective element index
        AND then calc, max leng val forn that array;
        We will use 2 pointer approach. j starts at 0 position and i starts 1 position
        ex: [9,1,4,2,3,3,7]
        first iteration: i=1 which means, 1index val is 1, j is 0, val is 9
        if(i val > j), the update that respetive index val by 1.
        once j=i, loop ends and i moves to next pointer and j goes back to 0;

        we update dp[i] val only if
        */
        if (nums.length == 0)
            return -1;

        int n = nums.length;
        int[] dp = new int[n];

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    // this is IMP and heart of problem
                    // If you just incremented a counter every time a previous number was smaller,
                    // you would get an incorrect sequence length because
                    // you aren't building on top of the best possible existing chain.
                    /*
                    The expression dp[j] + 1 means: "If I append my current number nums[i] to the
                    end of the longest valid sequence ending at j, my new sequence length becomes
                    dp[j] + 1."
                    */
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        return Arrays.stream(dp).max().getAsInt() + 1;
    }
}
