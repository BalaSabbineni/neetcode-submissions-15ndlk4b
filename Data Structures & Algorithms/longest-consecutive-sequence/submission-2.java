class Solution {
    public int longestConsecutive(int[] nums) {

        HashSet<Integer> hs = new HashSet<>();
        int longestConsecutive =0;

        for(int num: nums) {
            hs.add(num);
        }

        for(int num: nums) {
            if(!hs.contains(num-1)) {
                int len = 0;
                while(hs.contains(num+len)) {
                    len++;
                }
                longestConsecutive = Math.max(longestConsecutive, len);

            }
        }

        return longestConsecutive;


        
    }
}
