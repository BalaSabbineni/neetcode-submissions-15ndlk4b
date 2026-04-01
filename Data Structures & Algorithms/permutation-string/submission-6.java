class Solution {
    public boolean checkInclusion(String s1, String s2) {
    if (s2.length() < s1.length()) return false;


        int[] arr = new int[26];

        for (char ch : s1.toCharArray()) {
            arr[ch - 'a']++;
        }

        int l = 0, r = 0;
        char[] s2Char = s2.toCharArray();

        while (r < s2.length()) {
            arr[s2Char[r] - 'a']--;

            if ((r - l + 1) > s1.length()) {
                arr[s2Char[l] - 'a']++;
                l++;
            }

            if (isZero1(arr)) {
                return true;
            }
            r++;
        }

        return false;

    }

    private boolean isZero1(int[] arr) {
        for (int i = 0; i < 26; i++) {
            if (arr[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
