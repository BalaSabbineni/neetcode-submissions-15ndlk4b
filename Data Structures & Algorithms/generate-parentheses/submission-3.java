class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", n, 0,0);
        return result;
    }

    private void backtrack(List<String> result, String currentStr, int n, int open, int close) {

        // base case, we will get 2*n brackets ie.e open and close
        if(currentStr.length() == 2*n) {
            result.add(currentStr);
            return;
        }

        if(open < n) {
           backtrack(result, currentStr+"(", n, open+1, close); 
        }

        if(close < open) {
             backtrack(result, currentStr+")", n, open, close+1);  
        }


    }
}
