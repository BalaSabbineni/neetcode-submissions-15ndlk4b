// class TriNode {
    
// }

class PrefixTree {
    // create self refernce class similar to Linkedlist.
    // as discussed below need 26 size array
     private PrefixTree[] letters = new PrefixTree[26];
     // And we need a flag to tell end of the word is 
     private boolean isWord;


    // practice this question more.
    /* Denition:
    Trie is type of N-array tree. Unlike binary tree where Node has max two nodes.
    This N-array tree has multiple children.

    We use trie to store string. Each Node represent a string, and 
    each node can have several children.

    ROOT node is associated with empty string. 
    And Trie is used in applications for autocomplete, spell check etc,

    How search works is for example take a word "bad". 
    Think we have tree with several nodes.
    st we have root node which is empty.
    Assume, we have 3rd child nodes for root as a, b, c.
    now "a" child node has several child. One of child is "o" etc
    for "b" child has several child like "a" and "d" 
    same "c" child.

    For our search word is "bad". 
    so, we can find this word from "b" chid to subsequent child like "a"'s child "d"
    */

    /*
    We can define trie in many ways. One way is arrya with 26 size.
    why 26 size is, we have 26 letter either uppercase or lowercase and we need to serach words.
    so, this array works perfectly. 
    we store word's letter in array like this  = array['letter from word' - 'a'];

    We can use HashMap also.
    
    */

    public PrefixTree() {
         
    }

    public void insert(String word) {
        // get a TrieNode which is this class
        PrefixTree node = this;

        // now iterate word and add to letter array which we defined above
        for(char ch: word.toCharArray()) {
            // get index of letter
            int index = ch -'a'; // this method gives index of letter

            // next check current letter is there or not.
            // If not, add as new tree.
            if(node.letters[index] == null) {
                // add letter
                node.letters[index] = new PrefixTree();
            }
            // update node with added letter;
            node = node.letters[index];
        }

        // update isWord flag as true why becuase we just inseretd a word
        node.isWord = true;

    }

    public boolean search(String word) {
        /*
        same like insert, but below is the difference.
        how search works is, for example: "dog"
        starts from root node which is empty
        next we check child starts with first letter of word which is "d"
        if we find "d" then we go down to "d" node child to check that has "o" letter 
        if find "o" letters also we check it's child is "g".
        If it's we return true. 

        This is important. we find "dog" word, we return true only if "g" child must have ending.
        If there is no end, I mean "g" letter has one more with this letter "y",
        then word becomes "dogy" which is not equal to "dog".
        */

        // same like insert, get a TrieNode which is this class
        PrefixTree node = this;

        for(char ch: word.toCharArray()) {
            // get index of letter from word
            int index = ch - 'a';

            // now check this letter existed in node or not
            if(node.letters[index] == null) {
                // if not, we don't have this word.
                return false;
            }
             // MOVE TO NEXT LEVEL i.e next child
            node = node.letters[index];
        }
        // if word is exits, Trie class is already updated flag to true.
        // so, simply return it.
        return node.isWord;

    }

    public boolean startsWith(String prefix) {

        // same like search, but we don't need to return isWord

        PrefixTree node = this;

         for(char ch : prefix.toCharArray()) {
            int index = ch-'a';
            if(node.letters[index] == null) {
                return false;
            }
            // MOVE TO NEXT LEVEL i.e next child
            node = node.letters[index];
         }
         // In above for loop we are checking, prefix exists are not.
         // so, we cross the loop means, prefix exists.
         return true;

    }
}
