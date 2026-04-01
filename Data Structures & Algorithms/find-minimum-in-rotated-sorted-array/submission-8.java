class Solution {
    public int findMin(int[] nums) {
          if (nums.length == 1) return nums[0];

        int l = 0, r = nums.length - 1;
        //[2,3,1], [3,5,0,1,2], [1,2,3], [3,4,5,6,1,2]
        int min = nums[0];

        while (l <= r) {
            int mid = l + (r - l) / 2;
            min = Math.min(nums[mid], min);

            if (nums[mid] > nums[l]) {
                min = Math.min(nums[l], min);
                l = mid + 1;
            } else {
                min = Math.min(nums[r], min);
                r = mid - 1;
            }
        }
        return min;
    }
}
