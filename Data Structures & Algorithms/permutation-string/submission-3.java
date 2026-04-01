class Solution {
    public boolean checkInclusion(String s1, String s2) {
    int[] arr = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            arr[s1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s2.length(); i++) {
            arr[s2.charAt(i) - 'a']--;

            if ((i - s1.length()) >= 0) {
                arr[s2.charAt(i - s1.length()) - 'a']++;
            }

            if (isZero1(arr)) {
                return true;
            }

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
