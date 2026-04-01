class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;

        int l =0, r= 0;

        HashSet<Character> hashset = new HashSet<>();
        while(r < s.length()) {
            if(!hashset.contains(s.charAt(r))) {
                hashset.add(s.charAt(r));
                maxLen = Math.max(maxLen, hashset.size());
                r++;
            } else {
                 hashset.remove(s.charAt(l));
                 l++;
            }


        }

        

        return maxLen;
        
         
    }
}
