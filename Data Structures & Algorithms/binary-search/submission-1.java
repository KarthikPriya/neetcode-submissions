class Solution {
    public int search(int[] nums, int target) {
        if(nums == null)
            return -1;
        //Array is sorted
        int left = 0, right = nums.length-1;
        while(left<=right)
        {
            if(nums[left] < target)
                left++;
            else if(nums[right] > target)
                right--;
            else if (nums[left] == target)
                return left;
            else if(nums[right] == target)
                return right;
        }
        return -1;
    }
}
/*
[-1,0,2,4,6,8]
        l   r

*/