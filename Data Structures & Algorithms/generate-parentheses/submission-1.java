class Solution {
    public List<String> generateParenthesis(int n) {
      List<String> result = new ArrayList<>();
      backtrack("", result, 0,0,n);

      return result;  
    }

    private void backtrack(String currentStr,  List<String> result, int open, int close, int max) {

        if(currentStr.length() == 2* max) {
            result.add(currentStr);
            return;
        }

        if(open < max) {
           backtrack(currentStr+"(", result, open+1, close, max); 
        }
        if(close < open) {
           backtrack(currentStr+")", result, open, close+1, max); 
        }


    }
}
