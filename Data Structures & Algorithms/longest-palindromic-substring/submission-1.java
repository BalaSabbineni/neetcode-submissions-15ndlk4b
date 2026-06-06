class Solution {
    public String longestPalindrome(String s) {
        /*
        We need to use center and expand procedure for each character.
        two cases:
        1. Even len String:
        2. Odd len String:

        First, we start itration over string upto it's length and then we will use cneter and expand
        */

        if (s.length() <= 1)
            return s;

        String lps = "";

        // iterate over string
        // we need to start with 1 not 0
        for (int i = 1; i < s.length(); i++) {
            // we need two pointers to use center nd expand procedure for each char
            // both starts at same point which is at char positiin

            // 1st check is with Odd string length
            int low = i; //
            int high = i;

            // check paldrome or not
            while (s.charAt(low) == s.charAt(high)) {
                // move to left and right to check another character
                low--;
                high++;

                // check boundary conditions
                if (low == -1 || high == s.length()) {
                    break;
                }
            }
            // once loop breakes, get string and compare with exusting str leng;
            String newPlsStr = s.substring(low + 1, high);

            // update string if new pali str is long
            if (newPlsStr.length() > lps.length()) {
                lps = newPlsStr;
            }

            // check for even string length;
            // only change is low value to i-1, rest same
            low = i - 1;
            high = i;

            while (s.charAt(low) == s.charAt(high)) {
                low--;
                high++;

                if (low == -1 || high == s.length()) {
                    break;
                }
            }

            newPlsStr = s.substring(low + 1, high);

            if (newPlsStr.length() > lps.length()) {
                lps = newPlsStr;
            }
        }

        return lps;
    }
}
