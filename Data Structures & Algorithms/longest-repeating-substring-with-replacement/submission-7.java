class Solution {
    public int characterReplacement(String s, int k) {
        int maxLenStr = 0;

        HashMap<Character, Integer> hm = new HashMap<>();
        int l = 0, r = 0;
        int maxFreqOfLetter = 0;

        while (r < s.length()) {
            hm.put(s.charAt(r), hm.getOrDefault(s.charAt(r), 0) + 1);
            maxFreqOfLetter = Math.max(maxFreqOfLetter, hm.get(s.charAt(r)));

            if ((r - l + 1) - maxFreqOfLetter > k) {
                hm.put(s.charAt(l), hm.getOrDefault(s.charAt(l), 0) - 1);
                l++;
            }
            maxLenStr = Math.max((r - l + 1), maxLenStr);
            r++;
        }

        return maxLenStr;
       
    }
}
