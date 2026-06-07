class Solution {
    public int numDecodings(String s) {
        // this Q is similar to house robber one.
        /*
        1st Read and understood Q carefully.
        we will have letters from A to Z and mapped as 1 to 26 respectively.
        IMP: we need to handle 0 number. number 10 is valid, but not 01.

        As for every DP problems, we need array and store no of ways we can store in that particular
        index position

        we are taking arr with size of input number string and store in each index of number.

        Ex: If we have 2260, For memoiztion, we add first tow indexes as 1 if valid.
        next we start iterating from index 2 whuch is num 6.
        Now, we check cur num 6 is valid menas >=0 if single digit ND >=10 && <=26 fpr two digits
        If valid, then we simply update 6 number index val, by prev index -1 vl and prev Index-2 val
        eg: dp[i] += dp[i - 1]; and dp[i] += dp[i - 2];
        */

        int n = s.length();
        int[] dp = new int[n + 1]; // memoization arrya.

        // add fitst 2 vals
        dp[0] =
            1; // this is becuse, if i/p str is empty, then there wiull be only one way to decode it
        dp[1] = s.charAt(0) == '0'
            ? 0
            : 1; // this check is if input 01, then it's invalid. If b/w 1 to 9, we add 1 val

        // iterate over remain str
        for (int i = 2; i <= n; i++) {
            // now get last one digit and last 2 digits, like last 2 houses in rob probles,
            int oneDigit = Integer.valueOf(s.substring(i - 1, i));
            int twoDigits = Integer.valueOf(s.substring(i - 2, i));

            if (oneDigit >= 1) {
                dp[i] += dp[i - 1];
            }
            if (twoDigits >= 10 && twoDigits <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }
}
