class Solution {
    // we need to dFS with backtracking
     String[] mapDigits = {"","","abc","def","ghi", 
                        "jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
     List<String> result = new ArrayList<>();
     
     if(digits == null || digits.length() ==0) return result;

     dfs(result, digits, "",0);

     return result;   
    }

    private void dfs(List<String> result, String digits, String tempResult, int startIndex) {
        // base condition
        // when we reach input digits length, need to add to result
        if(startIndex == digits.length()) {
             System.out.println("tempResult 2: "+tempResult);
            result.add(tempResult);
            return;
        }

        // now, we need to loop input digit. we can get that using charAt
        char ch = digits.charAt(startIndex); 
        System.out.println(ch);
        
        // now, for input didgit ="34", In 1st iteration, ch will be 3 and next 4.
        // now we need to get string letters for respective digits.
        String letters = mapDigits[ch-'0'];
        System.out.println("letter: "+letters);

        // after this, letter = "def"
        // now, we need to do do backtrscking like permuatation
        for(char letter: letters.toCharArray()) {
            // call backtrack
            // add letter to result
            System.out.println("tempResult: "+tempResult);
            dfs(result, digits, tempResult + letter, startIndex+1);
        }

        
        
    }
}
