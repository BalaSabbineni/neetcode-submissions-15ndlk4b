class Solution {
    public int search(int[] nums, int target) {
        int l=0, r= nums.length-1;
        while (l <= r) {
            System.out.println(l + "-" + r);
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            //[3,5,6,0,1,2], target = 2

            if (nums[mid] > nums[l]) {
                if (nums[l] == target) {
                    return l;
                }
                if (nums[l] <= target && target < nums[mid]) {

                    r = mid - 1;
                } else {
                    l = mid + 1;
                }

            } else {
                System.out.println("uns");
                if (nums[r] == target) {
                    return r;
                }
                if (nums[r] >= target && target > nums[mid]) {
                    l = mid + 1;
                } else {
                    System.out.println("unso");
                    r = mid - 1;
                }

            }
        }

        return -1;
      
    }
}
