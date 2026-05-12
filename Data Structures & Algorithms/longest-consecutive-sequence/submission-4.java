class Solution {
    public int longestConsecutive(int[] nums) {
   if (nums.length == 0)
            return 0;
        int longest = 1;
        HashSet<Integer> hs = new HashSet<>();

        for (int i : nums) {
            hs.add(i);
        }

        for (int i = 0; i < nums.length; i++) {

            // we need to check prev element not existed or not.
            if (!hs.contains(nums[i] - 1)) {
                int len = 0;

                // then check next elemets are there by seq using +len
                // len starts at 0, next 1, next, 2 by sequence
                while (hs.contains(nums[i] + len)) {
                    len++;
                }
                longest = Math.max(longest, len);
            }
        }

        return longest;
    }
}
