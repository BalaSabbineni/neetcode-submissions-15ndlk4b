class Solution {
    public boolean canPartition(int[] nums) {
        /*
        Read and Understood Q carefully.
        we need to find subsets that sums are equal.

        so, first we need to calculate total sum of given nums
        then, divide that sum by half and check it's even or not

        **IMP**: If even, then only it's possible to get subsets
        if not even. then it's not possible

        So, Instead of using dfs or brute force to cal subset sums, we can use DP & Memeoization
        Same like word break and coin change problems
         */

        // int sum = Arrays.stream(nums).reduce(0, (a, b) -> a + b);
        // or
        int sum = Arrays.stream(nums).sum();

        // check if sum is even or not. If not return flase
        if (sum % 2 != 0)
            return false;

        // if even, get half of sum and try to check any subset contains this half
        // if we find any half val, then we found out target. why becuase we divide by 2.
        int halfSum = sum / 2;

        /*
        **IMP** DP logic is here
        we need a boolean dp array of size sum+1.
        Intially, all the indexs are false, expect 0th index.
        why because, we can always create partition 0 for sum 0,

        then for other indexs like 1,2,3...upto sum (half sum)
        we will check each index position with cur val from num and simply return that index value.
        ex: nums= [1,2,3,4], sum= 10, halfSum= 5. we need to find subset 5.
        we will create arry od halfSum which is 5.
        boolean[] dp = new boolean[halfSum + 1];

        now, we need iterate from backwards like from last index which is 5 position in this
        example.

        and then check dp array val like this. i-numsArryValue.
        for 1st iteration: i-numVal = 5-1= 4 . Here dp[4] is false; Intially all index r false
        expect 0. so, we update dp[i] which is dp[5] is false.

        next after going to i=1,
         i-numVal = 1-1=0. here dp[0] = true, we update dp[1]=true.

         same like iteration and memoization happens and last index val updates


        */
        boolean[] dp = new boolean[halfSum + 1];
        // 0th index is true
        dp[0] = true;

        // iterate over input array
        for (int num : nums) {
            // then iterate dp array from backwards
            // and check every index with given num val from input arry
            // **IMP** here j>= num not >=0 like traditional loop
            // we need reduce j upto only num value.
            for (int j = halfSum; j >= num; j--) {
               
                // IMP check, only add  dp[j] = true only whenn dp[j - num]
                if (dp[j - num]) {
                    dp[j] = true;
                }
            }
        }
        return dp[halfSum];
    }
}
