class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()) {
            return false;
        }

        int[] arr = new int[26];

        for (int i=0; i<s1.length(); i++) {
            arr[s1.charAt(i) -'a']++;
        }
        System.out.println("s1 arr: " + arr);

        for (int i=0; i<s2.length(); i++) {
            // now decrement arr with s2 letter to check arr indexs all are zero
            arr[s2.charAt(i) -'a']--;
            
            // once we reached our window that is s1 length, 
            // we need to remove that window letters fropm arr;
            // check window size using , current loop index i.e., i and s1 length
            // i-s1.lenght

            if((i-s1.length()) >=0) { // here we are siding window by removing  s1 length letters
              arr[s2.charAt(i-s1.length()) -'a']++;
            }

            if(isArrZero(arr)) { // this is to check arr indexes all are zero
                return true;
            }

        }
        return false;   
    }

    private boolean isArrZero(int[] arr) {
        for (int i=0; i< 26; i++) {
            if(arr[i] !=0) {
                return false;
            }
        }
        return true;
    }
}
