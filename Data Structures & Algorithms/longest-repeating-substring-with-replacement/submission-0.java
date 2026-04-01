class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> hm = new HashMap<>();
        char[] arr = s.toCharArray();

        int windowStart = 0, windowEnd = 0;
        int maxFreqLetter = 0, maxLenOfSubString = 0;


        while (windowEnd < s.length()) {

            hm.put(arr[windowEnd], hm.getOrDefault(arr[windowEnd], 0) + 1);
            maxFreqLetter = Math.max(maxFreqLetter, hm.get(arr[windowEnd]));


            if ((windowEnd - windowStart + 1) - maxFreqLetter > k) {
                hm.put(arr[windowStart], hm.get(arr[windowStart]) - 1);
                windowStart++;
            }
            maxLenOfSubString = Math.max(windowEnd - windowStart + 1, maxLenOfSubString);
            windowEnd++;

        }
        System.out.println(maxLenOfSubString);
        return maxLenOfSubString;
        
    }
}
