class Solution {
    public String minWindow(String s, String t) {
         if (s.length() < t.length()) return "";

        String minString = "";

        int l = 0, r = 0;
        int found = 0, toFind = t.length();

        int minWindow = Integer.MAX_VALUE;

        int[] arr = new int[128];

        for (char ch : t.toCharArray()) {
            arr[ch]++;
        }

        char[] sChar = s.toCharArray();
        while (r < s.length()) {
            arr[sChar[r]]--;

            if (arr[sChar[r]] >= 0) {
                found++;
            }

            while (toFind == found) { // we used while because we  decreases here arr[sChar[r]]--;, there can be duplicate characters and  arr[sChar[r]] count will be 2 also. So, we need to increase to make zero

                if (minWindow > (r - l + 1)) {
                    minWindow = r - l + 1;
                    minString = s.substring(l, r + 1);
                }

                arr[sChar[l]]++;

                if (arr[sChar[l]] > 0) {
                    found--;
                }
                l++;

            }

            r++;


        }

        return minString;
    }
}
