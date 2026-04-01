class Solution {
    public boolean checkInclusion(String s1, String s2) {
         if (s1.length() > s2.length()) {
            return false;
        }
    

        char[] s1Sort = s1.toCharArray();
        Arrays.sort(s1Sort);

        for (int i = 0; i <= s2.length()-s1.length(); i++) {
            char[] ss = s2.substring(i, s1.length()+i).toCharArray();
            Arrays.sort(ss);

            if ((new String(ss)).equals(new String(s1Sort))) {
                return true;
            }
        }

        return false;
        
    }
}
