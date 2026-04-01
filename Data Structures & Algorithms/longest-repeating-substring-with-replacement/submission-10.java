class Solution {
    public int characterReplacement(String s, int k) {

    int longest = 0;
        int l = 0, r = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        int mostFreqLetter = 0;

        while (r < s.length()) {
            hm.put(s.charAt(r), hm.getOrDefault(s.charAt(r), 0) + 1);
            mostFreqLetter = Math.max(mostFreqLetter, hm.get((s.charAt(r))));

            if ((r - l + 1) - mostFreqLetter > k) {
                hm.put(s.charAt(l), hm.getOrDefault(s.charAt(l), 0) - 1);
                l++;
            }
            longest = Math.max(longest, (r - l + 1));
            r++;

        }
        return longest;

       
    }
}
