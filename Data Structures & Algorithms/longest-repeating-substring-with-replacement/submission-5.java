class Solution {
    public int characterReplacement(String s, int k) {
        int mostFreqLetter = 0, maxLenOfStr = 0;

        HashMap<Character, Integer> hm = new HashMap<>();
        int windowStart = 0, windowEnd = 0;


        while (windowEnd < s.length()) {
            // calculate most freq letter
            hm.put(s.charAt(windowEnd), hm.getOrDefault(s.charAt(windowEnd), 0) + 1);
            mostFreqLetter = Math.max(mostFreqLetter, hm.get((s.charAt(windowEnd))));

            // check windowSize - mostFreqLetter >=k, here window size is substring
            System.out.println("window len: " + (windowEnd - windowStart + 1));
            if ((windowEnd - windowStart + 1) - mostFreqLetter > k) {
                hm.put(s.charAt(windowStart), hm.get(s.charAt(windowStart)) - 1);
                System.out.println("hm: " + hm);
                windowStart++;
            }

            maxLenOfStr = Math.max((windowEnd - windowStart + 1), maxLenOfStr);
            System.out.println(maxLenOfStr);
            windowEnd++;
        }

        return maxLenOfStr;
       
    }
}
