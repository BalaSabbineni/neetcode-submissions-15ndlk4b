class Solution {
    // Need these two variables to track leng
    private int resultStart = 0;
    private int maxLen = 0;

    public String longestPalindrome(String s) {
        // base check
        if (s.length() <= 1)
            return s;
        /*
        This is optimal soultion. Same like prev submission, we will use center and expand approach
        In this, instead of using substring() to check pali len, we will use leng
        */

        for (int i = 0; i < s.length(); i++) {
            expandAndCheckPali(s, i, i); // for odd len pali
            expandAndCheckPali(s, i, i + 1); // for even len pali
        }

        // we update resultStart and maxLen vals. Using this, get a sub ste
        return s.substring(resultStart, resultStart + maxLen);
    }

    private void expandAndCheckPali(String s, int left, int right) {
        // boundary and pali check
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // After loop, valid palindrome boundaries are (left + 1) to (righ - 1)

        // this right -left -1 is to get len of pali
        int curLen = right - left - 1;
        if (curLen > maxLen) {
            resultStart = left + 1;
            maxLen = curLen;
        }
    }
}
