class Solution {
    public int search(int[] nums, int target) {
      if (nums.length == 1 && nums[0] == target) {
            return 0;
        }
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
