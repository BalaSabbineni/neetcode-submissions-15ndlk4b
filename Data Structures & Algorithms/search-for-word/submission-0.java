class Solution {
    // read and focus more on this question
    // This is 2d array which need more focus and attention

    /*
    We need to find a word in the board.
    the word can formed in three ways. example find CAT.
    First we need to find 1st letter of word i.e., "C"
     then other two words can be in any THREE positions 
    like Beofre element, next element and below element
    I mean, if "C" is at board[0][2] and "A" is at below element board[1][2]
    and "T" is at "A"s next element or below or previous element.
    */

    /* we need to write a function to find word in before, below, next element.
    Need to use DFS with backtracking.
    After finding 1st letter, we need to check both 
    right & left sides, up, down. And mark visited spot as done or any flag.
    */
    public boolean exist(char[][] board, String word) {
        // we need to create nested for loop for any 2D array problems
        for (int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++) {
                // now we DFS with backtracking to check word exists or not

                if(dfs(board, word, 0, i, j)) {
                    return true;
                }

            }
        }
        return false;
        
    }

    private boolean dfs(char[][] board, String word, int index, 
                                                  int i, int j)  {
       // base check
       if(index == word.length()) return true;

       // we need a constraints that I and J don't cross board length
       // AND character mismatch. This **check very important**
       if (i<0 || i >= board.length || 
             j<0 || j>= board[i].length ||
             board[i][j] != word.charAt(index)) return false;

        // we need a temp and mark vsited spot as '#'
             char temp = board[i][j];
             board[i][j] = '#';
         
          // now  we need to go down, up side.
          /*
          for down, need to increase i by 1 'i+1' and keep colum same 'j'
          for up need to decrease row by 1 'i-1' and same coulmn j
          for right, need to keep same row and up column by 1 'j+1'
          for left, , need to keep same row and down column by 1 'j-1'
          */   
         boolean found =   dfs(board, word, index+1, i+1, j) ||  // this one goes down 
          dfs(board, word, index+1, i-1, j) || // this one goes up 
           dfs(board, word, index+1, i, j+1) ||  // this one goes coulmn down
            dfs(board, word, index+1, i, j-1); // this one goes coulmn up
 
 // now we need to reset temp, mark as unvisted.
     board[i][j] = temp;
     return found;

                                                  
    
}
}
