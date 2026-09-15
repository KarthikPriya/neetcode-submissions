class Solution {
    public boolean hasDuplicate(int[] nums) {
        if(nums == null)
            return false;
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i : nums)
        {
            if(set.contains(i))
                return true;
            else
                set.add(i);
        }
        return false;
    }
}