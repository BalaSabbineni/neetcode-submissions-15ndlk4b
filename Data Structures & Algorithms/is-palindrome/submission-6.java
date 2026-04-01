class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();

        int l =0, r=s.length()-1;

        while(l<r) {
            if(!Character.isLetterOrDigit(s.charAt(l))) {
                l++;
                continue;
            }

            if(!Character.isLetterOrDigit(s.charAt(r))) {
                r--;
                continue;
            }
            System.out.println("left: "+ s.charAt(l) +" ,right: " + s.charAt(r));

            if(s.charAt(l) != s.charAt(r)) {
               return false; 
            }
            l++;
            r--;
        }
        
        return true;
        
    }
}
