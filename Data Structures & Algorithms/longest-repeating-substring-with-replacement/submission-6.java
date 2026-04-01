class Solution {
    public int characterReplacement(String s, int k) {

int maxLen = 0;
        int maxFreqLetter = 0;

        HashMap<Character, Integer> hm = new HashMap<>();
        int l = 0, r = 0;

        while (r < s.length()) {
            // calculate max freq letter
            hm.put(s.charAt(r), hm.getOrDefault(s.charAt(r), 0) + 1);
            maxFreqLetter = Math.max(maxFreqLetter, hm.get(s.charAt(r)));

            // neeed to check window size string - maxFreqLetter >= k, If yes, need to remove "l" letter and move "l" to next letter by l++
            if ((r - l + 1) - maxFreqLetter > k) {
                hm.put(s.charAt(l), hm.get(s.charAt(l)) - 1);
                l++;
            }
            System.out.println(r + " " + l);

            maxLen = Math.max(maxLen, (r - l + 1));
            r++;
        }
        System.out.println(maxLen);

        return maxLen;
       
    }
}
