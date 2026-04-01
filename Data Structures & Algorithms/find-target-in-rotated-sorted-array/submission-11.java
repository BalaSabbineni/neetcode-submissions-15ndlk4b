class Solution {
    public int search(int[] nums, int target) {
      if (nums.length == 1 && nums[0] == target) return 0;
        //4, 5, 6, 7, 0, 1, 2     target = 0

        /*
         * We check to check the target number is present or not in given sorted rotated array.
         * If yes, return index of that target number, if No, return -1;
         *
         * We can use binary search.
         * First, we need to identify which half of array is sorted and check target is present in that half.
         * Eliminate window which doesn't have target. how can check this is?
         * Example arr = [4, 5, 6, 7, 0, 1, 2], target=0
         * In the arr,  sorted window side =  [4, 5, 6], unSorted= [0, 1, 2]
         * we need to check target element is greater or equal to first element of sorted window. If yes, our target will be in this
         *
         *
         */
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] == target) {
                return mid;
            }
            // check sorted or not
            if (nums[mid] >= nums[l]) { // sorted window
                // here window is [4, 5, 6]
                if (target >= nums[l] && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else { // unsorted window
                // here window is  [0, 1, 2]
                if (target <= nums[r] && nums[mid] <= target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }

        return -1;
    }
}
