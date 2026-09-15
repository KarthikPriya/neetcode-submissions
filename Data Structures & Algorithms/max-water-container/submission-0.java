class Solution {
    public int maxArea(int[] heights) {
        if(heights == null)
            return 0;
        int maxArea = 0;
        int left = 0, right= heights.length-1;
        while(left<right)
        {
            int newArea = (right-left)*(Math.min(heights[left], heights[right]));
            maxArea = Math.max(maxArea,newArea);
            if(heights[left]<heights[right])
                left++;
            else if(heights[left]>=heights[right])
                right--;
        }
        return maxArea;
    }
}
