class Solution {
    public int minCostClimbingStairs(int[] cost) {
      /**

      same like stair case problem, we need cost for reaching step 5 and step 6 if arr size is =7
      if step is cheap, then we take 2 steps from step 5, otherwise step 6 with step 1.
      how to reach top = 1 step from 6 or 2 steps from 5
      cost to reach top = [cost at syep 6 + min cost to reach 6, cost at step 5 + min cost to reach 5];
      
      finally,  take min cost from both;
      This is bottom to top approach.
      min_cost_toreac = MIN[(cost[n-1] + minCost(n-1)), (cost[n-2] + minCost(n-2))]
     we need to check cost at n-1 and n-2 at evry iteration and take min cost
      */  

      // for memoization, we need arry for stroing min cost 
      int n = cost.length;
      // min cost array which is dp array
      int[] minCost = new int[n+1];

      // intially, first step and 2nd step cost 0, so, we can start at step 3 which is index 2
      // then appy above formula
      for(int i=2;i<=n;i++){
        minCost[i] = Math.min( (cost[i-1] + minCost[i-1]), (cost[i-2] + minCost[i-2]) );
        // here, we are checking last two steps cost from current step
        // In first iteration, i=2 which step 3. the first two steps step 1 and stpe 2 costs are 0.
        // for last step, condition will be like this:
        // cost of 5 the step and cost of 6th step ans we will take min
      }
return minCost[n];

    }
}
