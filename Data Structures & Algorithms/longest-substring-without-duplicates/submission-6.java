class Solution {
    public int lengthOfLongestSubstring(String s) {
        int lengthOfLongestSubstring = 0;
        HashSet<Character> hs = new HashSet<>();

        int l = 0, r = 0;

        while (r < s.length()) {
            if (!hs.contains(s.charAt(r))) {
                hs.add(s.charAt(r));
                lengthOfLongestSubstring = Math.max(lengthOfLongestSubstring, hs.size());
                r++;
            } else {
                hs.remove(s.charAt(l));
                l++;
            }

        }

        return lengthOfLongestSubstring;
     }

}
