class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int i=0;
        while(i<nums.length){
            if(i != nums[i]){
                return i;
        }
        i++;
        }
        return i;
    }
}
