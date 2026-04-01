class Solution {
    public int maxArea(int[] heights) {
        int maxiArea =0;

        int left = 0, right= heights.length-1;

        while(left <= right) {
            int area  = (right - left) * Math.min(heights[left], heights[right]); 
             maxiArea = Math.max(area, maxiArea);

            if(heights[left] <= heights[right]) {
                left++;
            } else{
                right--;
            }

           
        }
        return maxiArea;
        
    }
}
