class Solution {
    public int climbStairs(int n) {
        /*
        This is DP problem. To solve DP Q's , we need to understand recursion. 

        DP is all about increasing speed and decressing space.
        we need array to track the next steps. Fibnoci series is the example problems
        */

        /**
        About this problem: Read nd understood Q carefully
        we have n no of steps to reach staircase. we can take 1 or 2 steps at a time.
        if n= 3; we can do it in 1 step + 1 step +1 step , 1 + 2, 2 + 1 
        then we reach out stair case in 3 ways.
        */

        // for DP problem, thus is base case. If n=1, just return it and no need do anyother steps
        if(n == 1) { // edge case
            return 1;
        }

        int[] dp = new int[n+1];
        dp[1] =1; // for first step,
        dp[2] =2; // for step 2

        for(int i=3; i<=n; i++){
            // this is key
            // the no of ways we can reach staricase is 
            // the no of ways we can reach to step[n-1] + step[n-2]; this is memoization.
            // if we have 7 steps, we can reach from step 5 using 2 steps or
            // from step 6 using 1 step.
            // here we are checking prev values in arry index elements
            // ex: i =3, then dp[3-1] + dp[3-2]; 
            // instead of recursion, doing like this by adding two prev numbers.
            dp[i] = dp[i-1] + dp[i-2];  // as per our eg: step 7 = step[5]+step[6];
            // here final i val = given n 
        }

        // then return last value;
        return dp[n];        
    }
}
