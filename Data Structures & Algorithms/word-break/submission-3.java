class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        /**
        we need to use dp boolean array of size input strng s length.
        and check char at index position and check backward upto maxword length in wordDict.
        so, we need to know maxwordLen from given input wordDict.
         */
        int maxLen = wordDict.stream().mapToInt(String::length).max().getAsInt();
        boolean[] dp = new boolean[s.length() + 1];
        // we need 0th index as true; why because if string is empty or len is zero, It's a valid.
        // we need to return true;
        dp[0] = true; // if str is empty, return true

        // iterate over string untill str len and check substring backwards and
        // check that subStr is present in wrdDict list
        // we can use hashSet for O(1) lookups instead of checking in list directly
        for (int i = 1; i <= s.length(); i++) {
            // get backword substring
            // base check  j >= 0 for boundar condition
            // and (i - j) <= maxLen for check upto only maxLen substr
            for (int j = i - 1; j >= 0 && (i - j) <= maxLen; j--) {
                // we will sub string with j,i
                if (dp[j] && wordDict.contains(s.substring(j, i))) { // use hashSet to check
                    // IMP: we need to check prev j index position is true or false
                    // If true, then only we need to add true
                    // Only mark dp[i] as true and break if BOTH the word is in the set AND dp[j] is
                    // true
                    dp[i] = true;
                    break; // if we found a word, then no need to check extra.
                }
            }
        }

        // return last val.
        return dp[s.length()];
    }
}
