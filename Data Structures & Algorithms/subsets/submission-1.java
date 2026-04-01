class Solution {
    // we need to use backtracking
    // to understand better, debug on code editor
    
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        /*
        We need a backtrack function which has result list, 
        empty list to pass, input array and start element

        To solve this problem, basically we need decide
        wheather we need to include current elemt or not.
        */
        backtrack(result, new ArrayList<>(),nums, 0);
        return result;
    }
    private void   backtrack(List<List<Integer>> result, List<Integer> tempSet, int[] nums, int start){

        // first we will add empty which tempset
        // later in backtrack calls we add elements to tempSet in bruteforce       
        result.add(new ArrayList<>(tempSet));
        // here we need to take i vaue as start which is zero
        // later we will increase it
      for(int i=start; i< nums.length; i++) {

        // include current element
        // beofre tempset is empty, now we added 1st element from input nums
        // later we will add all the elements one by one
        tempSet.add(nums[i]);

        // call backtrack with current element
        /*
        now, in 1st iteration, 
        result = [], tempst = {1}, nums, start 1
        before iteration all these zero
        now we are cheking one by one
        */
        backtrack(result, tempSet, nums, i+1);

        // remove existing element
        // why becuse we need to remove existing elment and need subset with another element
        tempSet.remove(tempSet.size()-1);

      }
    }
}
