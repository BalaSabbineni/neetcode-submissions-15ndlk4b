class Solution {
    public int[] productExceptSelf(int[] nums) {

        int prefix = 1, suffix = 1;
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            result[i] = prefix;
            prefix *= nums[i];
           // System.out.println(Arrays.toString(result));

        }

        for (int j = nums.length - 1; j >= 0; j--) {
            result[j] *= suffix;
            suffix *= nums[j];
           // System.out.println(Arrays.toString(result));
        }

        System.out.println(Arrays.toString(result));
        return result;
        
    }  
    }
 