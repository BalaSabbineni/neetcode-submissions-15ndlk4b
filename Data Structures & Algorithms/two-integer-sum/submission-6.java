class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i =0; i<nums.length; i++) {
            int dif = target - nums[i];
            if(hm.containsKey(dif)) {
                return new int[]{hm.get(dif), i};
            }
            hm.put( nums[i], i);
        }
        return new int[]{};
    }
}
