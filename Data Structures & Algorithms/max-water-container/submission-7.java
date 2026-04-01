class Solution {
    public int maxArea(int[] heights) {

        int water = 0;

        int l = 0, r = heights.length - 1;

        while (l < r) {
            int area = (r - l) * Math.min(heights[l], heights[r]);
            water = Math.max(area, water);
            if (heights[l] < heights[r]) {
                l++;
            } else {
                r--;
            }
            
        }

        return water;
    
    }
}
