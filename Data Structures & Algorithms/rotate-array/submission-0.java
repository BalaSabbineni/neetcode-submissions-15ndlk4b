class Solution {
    public void rotate(int[] nums, int k) {
        // first we need to rotate full array
        // then rotate by k% time for left and right
        int length = nums.length;
        k %= length;
        rotate(nums, 0, length-1);
        // rotate k times in left and right
        rotate(nums, 0, k-1);
        rotate(nums, k, length-1);
        
    }

    private void rotate(int[] nums, int l, int r) {
        // swap 
        while(l <= r) {
            int temp = nums[l];
            nums[l]=nums[r];
            nums[r]=temp;
            l++;
            r--;
        }
    }
}