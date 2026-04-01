class Solution {
    public int lengthOfLongestSubstring(String s) {
        int subStrLen = 0;

        HashSet<Character> hs = new HashSet<>();

        int l = 0, r = 0;
        char[] ch = s.toCharArray();
        while (r < s.length()) {

            if (!hs.contains(ch[r])) {
                hs.add(ch[r]);
                subStrLen = Math.max(subStrLen, hs.size());
                r++;
            } else {
                hs.remove(ch[l]);
                l++;
            }


        }
        return subStrLen;
     }

}
