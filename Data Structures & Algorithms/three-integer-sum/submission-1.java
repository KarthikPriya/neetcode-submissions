class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums == null)
            return new ArrayList<List<Integer>>();
        //let's sort the Array - to easily avoid duplicates
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i=0;i<nums.length;i++)
        {
            //avoid duplicate at the first element i
            if(i>0 && nums[i] == nums[i-1])
                continue;

            int target = -(nums[i]);
            int left = i+1,right = nums.length-1;
            //[-4,-1,-1,0,1,2] i =1, l=2, r=5
            while(left < right)
            {
                if(nums[left]+nums[right] < target)
                    left++;
                else if (nums[left]+nums[right] > target)
                    right--;
                else if(nums[i]+nums[left]+nums[right] == 0)
                {
                    List<Integer> sublist = new ArrayList<>();
                    sublist.add(nums[i]);
                    sublist.add(nums[left]);
                    sublist.add(nums[right]);
                    result.add(sublist);
                    while(left<right && nums[left] == nums[left+1])left++;
                    while(left<right && nums[right] == nums[right-1])right--;
                    left++;
                    right--;
                }
            }
        }
        return result;
    }
}
