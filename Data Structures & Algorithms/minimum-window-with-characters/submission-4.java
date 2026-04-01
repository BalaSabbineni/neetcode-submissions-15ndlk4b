class Solution {
    public String minWindow(String s, String t) {
 if (s.length() < t.length()) return "";
        String minStr = "";

        int toFind = t.length(), found = 0;
        int l = 0, r = 0;

        int[] arr = new int[126];

        for (char ch : t.toCharArray()) {
            arr[ch]++;
        }

        int minWindow = Integer.MAX_VALUE;

        while (r < s.length()) {
            arr[s.charAt(r)]--;

            if (arr[s.charAt(r)] >= 0) {
                found++;
            }

            while (found == toFind) {

                if (minWindow > (r - l + 1)) {
                    minWindow = r - l + 1;
                    minStr = s.substring(l, r + 1);
                }

                arr[s.charAt(l)]++;
                if (arr[s.charAt(l)] > 0) {
                    found--;
                }
                l++;


            }


            r++;

        }

        return minStr;
    }
}
