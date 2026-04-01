class Solution {
    public int findMin(int[] nums) {
          if (nums.length == 1) return nums[0];

        int l = 0, r = nums.length - 1;
         // explanation
        /*
         * We need to identify which part is sorted.
         * After finding sorted window, find the min element in that window and eliminate that window.
         * In next window find sorted side and find min  element form tha window and eliminate it.
         * In this example, [3,5,0,1,2], l=3, mid = 0, h=2
         * sorted window is mid to h (o to 2).
         * Find min element form this window min= math.min(nums[mid], min) and eliminate like this r= mid-1;
         * now window = [[3,5] l=3 m=3, h=5. find min  element
         */
        int min = nums[0];

        while (l <= r) {
            int mid = l + (r - l) / 2;
           
            if (nums[mid] >= nums[l]) {
                min = Math.min(nums[l], min);
                l = mid + 1;
            } else {
                min = Math.min(nums[mid], min);
                r = mid - 1;
            }
        }
        return min;
    }
}
