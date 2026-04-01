class Solution {
    public int longestConsecutive(int[] nums) {
         int result = 0;

        HashSet<Integer> hs = new HashSet<>();
        for (int n : nums) {
            hs.add(n);
        }

        for (int i = 0; i < nums.length; i++) {

            if (!hs.contains(nums[i] - 1)) {
                int len = 0;
                while (hs.contains(nums[i] + len)) {
                    len++;
                }
                result = Math.max(result, len);
            }

        }
        System.out.println(result);
        return result;

           
    }
}
