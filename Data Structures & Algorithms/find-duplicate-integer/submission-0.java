class Solution {
    public int findDuplicate(int[] nums) {
        /*
         * we can find duplicate using brute force approach and hashset,
         * but these are O(n) and O(n log n) time complexity, but we need extra space.
         *
         * We can also find using detecting a loop using LL approach without extra space.
         *
         * we have this [2, 1, 2, 3], where 2 is repeated, we mark the index corresponding to each element as negative.
         * If we encounter a number whose corresponding position is already negative, it means the number is a duplicate, and we return it.
         *
         * Cycle detection: In array we have index and it's value. So, Iterate over array and for index, get the index value and create a node and make this index value as next index.
         * Eg: [2,1,2,3]. Here Index 0 and value is 2. next iteration consider this value as index. Now index is 2 not 1 which us usually after 0 index.
         * now at index 2 value is 2. Go to in
         */
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow]; // this for first index which is 0 and getting value; here slow will be 2 for first iteration

            // next, we need to move fast pinter.after this fast = = nums[nums[fast]]; fast = nums[2] which is 2. Here fast pointer moved two places.
            //
            fast = nums[nums[fast]];
        } while (fast != slow); // we need to do until fast != null

        // once fast and slow met, to find the duplicate. make slow as 0 and iterate
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];

        }
        return slow;
    }
}
