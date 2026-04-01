class Solution {
    public List<String> generateParenthesis(int n) {
      


        List<String> result = new ArrayList<>();
        backtrack1(result, n, 0,0,"");
        return result;
    }

    private void backtrack1(List<String> result, int max, int open, int close, String currentStr) {

        if (currentStr.length() == 2 * max) {
            result.add(currentStr);
        }
        if (open < max) {
            backtrack1(result, max, open + 1, close, currentStr + "(");
        }
        if (close < open) {
            backtrack1(result, max, open, close + 1, currentStr + ")");
        }

    }
}
