class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // need to use set to avoid duplicates.
        backtrack(result, nums, new LinkedHashSet<>());
       
        return result;
    }

    private void backtrack(List<List<Integer>> result, int[] nums, 
    Set<Integer> currentResult) {
        // base condition is , we need  our currentResult size == nums.length
        // why becuase we need permuation for nums.lenght elements
        if(currentResult.size() == nums.length) {
            result.add(new ArrayList<>(currentResult));
            return;
        }
        

        for(int i=0; i<nums.length;i++) {
            // add all nums elements to currentResult without duplicates
            if(!currentResult.contains( nums[i])) {
            currentResult.add(nums[i] );
            System.out.println("1: "+ currentResult);
            backtrack(result, nums, currentResult);

            // rempve existing elements
            currentResult.remove(nums[i]);
            System.out.println("2: "+ currentResult);
            }

        }
    }
    private int fact(int n) {
        if(n == 0) return 1;
        return n * fact(n-1);
    }
}
