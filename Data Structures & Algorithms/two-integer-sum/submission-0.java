class Solution {
    public int[] twoSum(int[] nums, int target) {
        //edge case
        if(nums.length == 0 || nums.length == 1)
            return new int[]{};
        for(int i=0;i<nums.length;i++)
        {
            int diff = target - nums[i];
            for(int j=0;j<nums.length;j++)
            {
                if(i != j)
                {
                    if(nums[i]+nums[j] == target)
                        return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }
}
