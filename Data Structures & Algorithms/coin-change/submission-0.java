class Solution {
    public int coinChange(int[] coins, int amount) {
        /*
        tricky Q, practice more. We need min no of coins to male given amount.
        if cpins = [1,2,3], amount = 7. we can make amount in these ways.
        with coin 1: we need 7 coins; coin 2: 2+2+2+1(with first coin)= 4 coins needed
        with coint 3: 3+3+1= 3 coins needed.
        so, min is 3.

        we need a dp array of size amount+1; and we will store at each index, how many coints needed
        for that partivcular index val. at index 1, we have 1 coins, so, we need 7 coins. we store 7
        in that index. at index 2, we have 2 coints,we need  2+2+2+1(with first coin)= we store 4 in
        that index. same like this for all the coins.

        What's the minimum coins needed to reach score 1? score 2? score 3?... score 11?"

        Here Key is, as for every dp problems,
        we need to compare with last two prev index vals and take MIN val;
         */

        if (amount < 1)
            return 0;
        // need arr pf sixe amount+1;
        int[] dp = new int[amount + 1];
        Arrays.sort(coins);

        // iterate over until amoutn size. start from index 1. why becasue for 0 amount, we don't
        // need any coins
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;
            // iterate over coin array and cal we reached out target or not
            for (int coin : coins) {
                // need to target to check given coin i
                // confusing part.
                /*
                for first iteration i=1; target is 1-1=0, so dp[1] = min(amount + 1, dp[target]+1)
                here target is 0. so dp[0]+1;

                for next iteration i=2; target = 2-1=1, so dp[1] = min(amount + 1, dp[target]+1)
                ere target is 1. so dp[1]+1; for amount 2, we need 2 coins

                same like this. for i=12 which nothing but amount 12.
                tarhget = i-coin = 12-1=11. we are iterating coints array that's why 1.
                taget > 0. so, dp[12] = min(dp[i] here val= amount+1, dp[target]+1) here target
                is 11. min(dp[i], dp[11]+1);

                */
                int target = i - coin;

                // if target < 0, then break it. For this, we need to sort.
                if (target < 0) {
                    break;
                }
                // if not cal, min . For first coint, dp[i] is zero. so, we need to add
                // dp[1]  as max val like this amount+1;
                // this is formula;
                dp[i] = Math.min(dp[i], dp[target] + 1);
            }
        }

// at final check given amount index position val is > amount if not, return that index val. otherwise -1
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
