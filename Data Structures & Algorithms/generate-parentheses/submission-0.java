class Solution {
    public List<String> generateParenthesis(int n) {
   /* To generate parenthesis, we need a open "(" and a close ")" eg. ()
         * If we have n=1, then we will have 1 open and one close,
         * if n=2, 2+2 parenthesis, if 3, 3+3 parenthesis ...
         * basically, if n, then we will get 2n parenthesis
         */

        /*
         * For this problem, we can use backtracking and also stack.
         * First, To get a valid parenthesis, we need a combination of open and close brackets
         * we can't start with close bracket. so, open bracket first.
         *
         * For any backtracking, we need a base case.
         * Here, base case is max no of parenthesis number we have. that is 2*n = 3. so string.length = 2*n
         * Once we satisfy the base case, we will add that string to result list. Here string is in form parenthesis string like this "((()))"
         * base case eg.: if(current_string == 2*n) , theh add string to result list.
         *
         * Now, we need add brackets to string to make out base case true.
         * First, we need to add open bracket until less than manx(n*2) and call our backtrack method in function and also we need to increase open count
         *
         * Next, we need to add closing bracket until, close less than open bracket. then call  backtrack method in function and also we need to increase close count
         *
         */

        List<String> result = new ArrayList<>();

        backtrack(result, n, 0, 0, "");

        return result;

    }

    private void backtrack(List<String> result, int max, int open, int close, String currentString) {

        if (currentString.length() == 2 * max) {
            result.add(currentString);
            return;
        }

        if (open < max) {
            backtrack(result, max, open + 1, close, currentString + "(");
        }

        if (close < open) {
            backtrack(result, max, open, close + 1, currentString + ")");

        }    
    }
}
