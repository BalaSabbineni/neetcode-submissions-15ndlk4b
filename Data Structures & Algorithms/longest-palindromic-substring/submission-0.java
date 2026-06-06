class Solution {
    // we can do this brute force way, but not optimal solution
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1)
            return "";
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j <= s.length(); j++) { // need to check last element, so use r <=
                if (isPali(s.substring(i, j))) {
                    if (s.substring(i, j).length() > str.length()) {
                        str = s.substring(i, j);
                    }
                }
            }
        }

        return str;
    }

    private boolean isPali(String s) {
        int l = 0, r = s.length() - 1;
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
