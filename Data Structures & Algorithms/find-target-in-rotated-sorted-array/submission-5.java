class Solution {
    public int search(int[] nums, int target) {
        if(nums == null)
            return -1;
        int left = 0, right = nums.length-1;
        while(left<=right)
        {
            int mid = left + (right-left)/2;
            if(nums[mid] == target)
                return mid;
            //left is sorted
            if(nums[left]<= nums[mid])
            {
                if(nums[left]<=target && nums[mid]>target)
                    right = mid-1;
                else
                    left = mid+1;
            }
            else
            {
                if(nums[mid]<target && target<=nums[right])
                    left = mid+1;
                else
                    right = mid-1;
            }
            
        }
        return -1;
    }
}
/*
 0 1 2 3 4 5 6
[4,5,6,7,0,1,2] target =0
         l
        mr
*/