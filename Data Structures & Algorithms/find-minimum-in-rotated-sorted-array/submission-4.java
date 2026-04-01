class Solution {
    public int findMin(int[] nums) {
         if (nums.length == 0) return -1;
        if (nums.length == 1) return nums[0];
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int midPoint = l + (r - l) / 2;
            System.out.println(midPoint + " :index and it's value: " + nums[midPoint]);

             if (midPoint > 0 && nums[midPoint] < nums[midPoint - 1]) {
                return nums[midPoint];
            } else if (nums[midPoint] >= nums[l] && nums[midPoint] > nums[r]) {
                l = midPoint + 1;
            } else {
                r = midPoint;
            }

        }
         System.out.println(nums[l]);
        return nums[l];
    }
}
