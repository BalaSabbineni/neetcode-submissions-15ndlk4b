class Solution {
    public boolean checkInclusion(String s1, String s2) {
    int[] arr = new int[26];
        for (char ch : s1.toCharArray()) {
            arr[ch - 'a']++;
        }

        int l = 0, r=0;
        while (r < s2.length()) {
            arr[s2.charAt(r) - 'a']--;

            if (((r) - s1.length()) >= 0) {
                arr[s2.charAt(l) - 'a']++; // here sliding from fist letter of s2. here l =0, then 1 etc
                l++;
            }
            if (zero(arr)) {
                return true;
            }
            r++;
        }


        return false;
         }

    private boolean zero(int[] arr) {
        for (int i = 0; i < 26; i++) {
            if (arr[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
