class Solution {
    public int characterReplacement(String s, int k) {
        int maxLen =0;
        HashMap<Character, Integer> hm = new HashMap<>();
        int maxFreqLetter =0;
        int windowStart=0, windowEnd=0;

        while(windowEnd < s.length()) {
            // count and add max freq letter 
            hm.put(s.charAt(windowEnd), hm.getOrDefault(s.charAt(windowEnd), 0)+1);
            maxFreqLetter = Math.max(maxFreqLetter, hm.get(s.charAt(windowEnd)));

            // check window length - fre > k

            if((windowEnd-windowStart+1) - maxFreqLetter > k ) {
                hm.put(s.charAt(windowStart), hm.get(s.charAt(windowStart))-1);
                windowStart++;
            } 
                maxLen = Math.max(maxLen, (windowEnd-windowStart+1));
                windowEnd++;
            

        }



        return maxLen;
    }
}
