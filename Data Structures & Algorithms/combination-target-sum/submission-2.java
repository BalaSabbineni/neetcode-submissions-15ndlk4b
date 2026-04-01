class Solution {
    // we need to use backtracking
    /*
    for any bracktracking we need a base condition.
For this problem base case is target.
we will backtrack each element from nums input and
check target ==0 or target < 0
    */
    public List<List<Integer>> combinationSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();
        /*
         we need a backtrack function
         that need these arguments
         result, nums, target
         tempResult or current list: to add combo elements to result
         start: which is our start index, we will pass as 0 intially.

        */

        /* to optime more we can sort input array also
        when intervieer asked to optime more, do this
        Arrays.sort(nums);
        */
         
        backtracking(result, nums, target, new ArrayList<>(), 0);
        return result;
    }

    private void  backtracking(List<List<Integer>> result, int[]nums, 
          int target, List<Integer> current, int start) {
            // base condition
            // we will reduce this target by adding element in baacktack
            // if target ==0, then we got our combo
            if(target == 0) {
                result.add(new ArrayList<>(current));
                return;
            }

            // one base check 
            // this means, our combo is not correct one
            // for example, if we add [2,5,6] then it wlll be greater 
            if(target < 0) {
                return;
            }

            for (int i = start; i< nums.length; i++) {

                /* to optime more we can sort input array also
          when intervieer asked to optime more, do this
        if(num[i] > target) {
            break;
        }
        */

                // add elements from nums array to current list
                current.add(nums[i]);

                /*
                backtrack here
                need to pass 
                result list: for adding out combo list
                nums: for iterating

                these are important
                1. target - nums[i]: we are substracting current element from target 
                and doing it untill we reach base case. 
                Either target will be 0, the we add taht combo
                or taget < 0, then return; whuch is not a combo;
                2. we are updating  start value as "i" why because duplicates are allowed.
                For no duplicates, we will start+i like subsets problem


                */
                backtracking(result, nums, target - nums[i], current, i);

                // remvoe existing element
                current.remove(current.size()-1);
            }

    }
}
