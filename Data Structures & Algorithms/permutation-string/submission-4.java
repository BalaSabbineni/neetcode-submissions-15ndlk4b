class Solution {
    public boolean checkInclusion(String s1, String s2) {
     int[] arr = new int[26];

        for (char ch : s1.toCharArray()) {
            arr[ch - 'a']++;
        }

        int l = 0, r = 0;

        while (r < s2.length()) {
            // reduce on arr with s2 letter; This is to check all arr elements are zero.
            arr[s2.charAt(r) - 'a']--;

            if ((r - s1.length()) >= 0) { // check iteration length on s2 is > 0
                arr[s2.charAt(l) - 'a']++;
                l++;
            }

            // now check arr is zero or not

            if (isArrZero(arr)) {
                return true;
            }
            r++;
        }

        return false;

    }

    private boolean isArrZero(int[] arr) {
        for (int i = 0; i < 26; i++) {
            if (arr[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
