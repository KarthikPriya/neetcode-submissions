class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums == null)
            return new int[0];
        
        int[] result = new int[nums.length];
        int left = 1, right=1;
        int[] leftsum = new int[nums.length];
        int[] rightsum = new int[nums.length];
        leftsum[0] = left;
        rightsum[nums.length-1] = right;
        for(int i=1;i<nums.length;i++)
        {
            leftsum[i]=leftsum[i-1]*nums[i-1];
        }
        //System.out.println(Arrays.toString(leftsum));
        for(int i=nums.length-2;i>=0;i--)
        {
            rightsum[i]=rightsum[i+1]*nums[i+1];
        }
        //System.out.println(Arrays.toString(rightsum));
        
        for(int i=0;i<nums.length;i++)
        {
            result[i] = leftsum[i]*rightsum[i];
        }
        return result;
    }
}  
/*
 0 1 2 3
1[1,2,4,6]1
 [1,1,2,8]left sum
 [48,24,6,1]right sum
product = 2
*/