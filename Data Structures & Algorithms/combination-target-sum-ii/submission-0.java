class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
         List<List<Integer>> result = new ArrayList<>();
         Arrays.sort(candidates);
         backtrack(result,candidates, target, new ArrayList<>(), 0);
         return result;
    }
    private void backtrack(List<List<Integer>> result,int[] candidates, int target, 
    List<Integer> currentResult, int start){

        if(target == 0) {
            
            
            result.add(new ArrayList<>(currentResult));
            return;
            

        }

        if(target < 0) {
            return;
        }

        for(int i = start; i < candidates.length;i++) {
        if(candidates[i] > target) {
            break;
            }
    // skip duplicates
    if(i > start && candidates[i] == candidates[i-1]) continue;

        currentResult.add(candidates[i]);

        // ✅ Use i + 1 when each element can only be used once
// (e.g. combinationSum2, subsets without repetition)

        backtrack(result, candidates, target - candidates[i], currentResult, i+1);

        currentResult.remove(currentResult.size()-1);
        }

    }
}
