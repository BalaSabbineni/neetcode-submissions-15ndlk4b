class Solution {
    public String minWindow(String s, String t) {
         if (s.length() < t.length()) return "";
        String minStr = "";

        int[] tCountArr = new int[128];

        for (char ch : t.toCharArray()) {
            tCountArr[ch]++;
        }

        int l = 0, r = 0;
        int toFind = t.length(), found = 0;
        int minWindow = Integer.MAX_VALUE;

        while (r < s.length()) {
            tCountArr[s.charAt(r)]--;

            if (tCountArr[s.charAt(r)] >= 0) {
                found++;
            }

            while (toFind == found) {

                int currentWindowSize = r - l + 1;

                if (minWindow > (currentWindowSize)) { // here if currentWindowSize less mean, less substring
                    minWindow = currentWindowSize;
                    minStr = s.substring(l, r + 1);
                }

                tCountArr[s.charAt(l)]++;
                if (tCountArr[s.charAt(l)] > 0) {
                    found--;
                }
                l++;

            }
            r++;
        }


        return minStr;
    }
}
