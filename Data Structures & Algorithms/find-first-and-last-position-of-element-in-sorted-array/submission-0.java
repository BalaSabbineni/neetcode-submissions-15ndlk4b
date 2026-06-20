class Solution {
    public int[] searchRange(int[] nums, int target) {
        /**
        This is tricky question. we need to find a range of given target
        For normal single target, we can simply use mid and if present return index.
        But this, we can have multiple targets and we need to return start and last positions.    
        IMP: we need to binary search, but two times mean on left side and right side after getting mid
         */

        if (nums.length == 0)
            return new int[] { -1, -1 };

        // now, we need to binary search on both sides.
        // if left has target, that will be 0th index for result, why because, array is sorted.

        int left = leftBinarySearch(nums, target);
        int right = rightBinarySearch(nums, target);
        return new int[] { left, right };
    }

    private int leftBinarySearch(int[] nums, int target) {
        int index = -1; // IMP: need this to check more left side values and to store result
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                /** 
                IMP: If we found target, then we still need to check left side for any more target and store or update reuslt in index.
                then move right to left side, why becuse we need to check left start posotion
                */
                index = mid;
                right = mid - 1; // IMP: move right to left side
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return index;

    }

    private int rightBinarySearch(int[] nums, int target) {
        int index = -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                /** 
                IMP: If we found target, then we still need to check right side and store or update reuslt in index
                 then move left to right side, why becuse we need to check right end posotion
                */
                index = mid;
                left = mid + 1; // IMP: move left to right side
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return index;
    }

}
