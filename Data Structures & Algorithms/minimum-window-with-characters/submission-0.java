class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";

        String minWindowStr = "";

        int[] arr = new int[128];

        for (char ch : t.toCharArray()) {
            arr[ch]++;
        }

        // here arr value is like this as letter position count: 0 0 0 1 1 1 0..  (x=1, y=1. z=1)

        int l = 0, r = 0;
        int found = 0, toFind = t.length();
        int minWindowLen = Integer.MAX_VALUE;

        while (r < s.length()) {
            System.out.println("1:, " + s.charAt(r) + ", " + arr[s.charAt(r)]);
            arr[s.charAt(r)]--;
            System.out.println("2:, " + s.charAt(r) + ", " + arr[s.charAt(r)]);
            // after reducing arr with s string, then any matching letter will be reduced like 0 or -1 or -2 etc/

            if (arr[s.charAt(r)] >= 0) { // here we are checking s string letter matches with t string letter, then we can add to found count
                found++;
            }

            while (toFind == found) { // here we met out target, so, we need to slide the window (l++) and checking for min string and make found to zero

                if (minWindowLen > (r - l + 1)) {
                    minWindowLen = r - l + 1;
                    minWindowStr = s.substring(l, r + 1);
                }
                arr[s.charAt(l)]++;
                if (arr[s.charAt(l)] > 0) {
                    found--;

                }

                l++;


            }
            System.out.println(r - l + 1);
            r++;

        }
        System.out.println(minWindowStr);
        return minWindowStr;
    }
}
