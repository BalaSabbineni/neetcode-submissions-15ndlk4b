class Solution {
    public int characterReplacement(String s, int k) {

        int longest = 0;
        HashMap<Character, Integer> hm = new HashMap<>();

        int l = 0, r = 0, mostFreqLetter = 0;
        char[] ch = s.toCharArray();

        while (r < s.length()) {
            //AAABABB
            hm.put(ch[r], hm.getOrDefault(ch[r], 0) + 1);

            mostFreqLetter = Math.max(mostFreqLetter, hm.get(ch[r]));

            if ((r - l + 1) - mostFreqLetter > k) {
                hm.put(ch[l], hm.getOrDefault(ch[l], 0) - 1);
                l++;
            }
            longest = Math.max((r - l + 1), longest);
            r++;
        }

        return longest;

       
    }
}
