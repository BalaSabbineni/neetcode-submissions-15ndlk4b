class Solution {
    public boolean checkInclusion(String s1, String s2) {
      if (s2.length() < s1.length()) return false;
        int[] arr = new int[26];

        for (char ch : s1.toCharArray()) {
            arr[ch - 'a']++;
        }

        int l = 0, r = 0;
        while (r < s2.length()) {
            arr[s2.charAt(r) - 'a']--;

            if ((r - l + 1) > s1.length()) {
                arr[s2.charAt(l) - 'a']++;
                l++;
            }

            if (isArrZero(arr)) {
                return true;
            }
            r++;


        }
        return false;
    

        
    }
    private boolean isArrZero(int[] arr) {
            for(int i=0; i< 26; i++) {
                if(arr[i] !=0) {
                    return false;
                }
            }
            return true;
        }
}
