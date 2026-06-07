class Solution {
    public int countSubstrings(String s) {
        if (s.length() == 1)
            return 1;
        /*
        Same like long pali substr problem, in this we need to count all possible sub strs.
        Need to use same center and expand procedure for both odd and even strs.
        need a helper function to chek str is pali and increase count
        */

        // for result
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            // this is for odd len pali. need to pass i and later we exapnd left nd right
            count += checkPali(s, i, i);

            // this is for even len palid, need to pass i and i+1 and we eexpand to left and right
            count += checkPali(s, i, i + 1);
        }

        return count;
    }

    private int checkPali(String str, int left, int right) {
        /*
        str: this is str from expanding from center.
        left: start of str
        right: end of str and we will check str is pali or not
        */

        int count = 0;
        // boundary conditions
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }
}
