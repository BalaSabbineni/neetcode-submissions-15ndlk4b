class Solution {
    public int maxProduct(int[] nums) {
        int maxProd = nums[0];
        int curProd = nums[0];
        int minProd = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // IMP: we need handle -ve values.
            // If cur sum is -5 and next elem is -6. Then prod will be +30
            // need temp to check both -ve*-ve case
            int temp = Math.max(nums[i], Math.max((curProd * nums[i]), (minProd * nums[i])));

            // in every iteration, check min value
            minProd = Math.min(nums[i], Math.min((curProd * nums[i]), (minProd * nums[i])));
           
            curProd = temp;
            maxProd = Math.max(maxProd, curProd);
        }

        return maxProd;
    }
}
