class Solution {
    public int[] twoSum(int[] nums, int target) {
        //edge case
        if(nums.length == 0 || nums.length == 1)
            return new int[]{};
        //hashmap to store the elements
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++)
        {
            int num = nums[i];
            int diff = target -  num;
            if(map.containsKey(diff))
                return new int[]{map.get(diff),i};
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
