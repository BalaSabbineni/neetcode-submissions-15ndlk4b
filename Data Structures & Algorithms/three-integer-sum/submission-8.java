class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
       HashSet<List<Integer>> hs = new HashSet<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum == 0) {
                    List<Integer> list = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k]));
                    hs.add(list);
                    j++;
                    k--;
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }

        return new ArrayList<>(hs);
}
}
