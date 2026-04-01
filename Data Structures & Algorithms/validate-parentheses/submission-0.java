class Solution {
    public boolean isValid(String s) {
        /*
         * we need to use stack for this problem, stack follows LIFO approach.
         *
         * First we need to iterate over string and add str character to stack (stack,push()).

         * After adding one character, to add next character (think like closing bracket), we need to check before element in stack is present or not.
         If present, we need to check it is a opening bracket or not . If it is, we will pop out.
         *
         * follow this foe all types of brackets. Basically, first we will add one type bracket and in next step we will check previous one closing ot not.
         If not, check for another bracket.
         *
         * Like this we need to do for every character.
         *
         * lastly, we need to  check, stack is empty or not. If empty, return  true else false;
         *
         */
         
        Stack<Character> op = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
        

            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                op.push(s.charAt(i));
            } else if (op.isEmpty()) {
                return false;
            } else if (s.charAt(i) == ')' && op.peek() == '(') {
                op.pop();
            } else if (s.charAt(i) == '}' && op.peek() == '{') {
                op.pop();
            } else if (s.charAt(i) == ']' && op.peek() == '[') {
                op.pop();
            } else {
                return false;
            }

        }

        return op.isEmpty() ? true : false;
    }
}
