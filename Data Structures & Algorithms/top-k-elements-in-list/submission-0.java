class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //edge case
        if(nums == null || nums.length == 0)
            return new int[]{};
        //frequency map
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for(int i:nums)
        {
            frequencyMap.put(i, frequencyMap.getOrDefault(i,0)+1);
        }
        //System.out.println(frequencyMap);
        ArrayList<Integer>[] buckets = (ArrayList<Integer>[]) new ArrayList[nums.length+1];
        for (int i = 0; i < buckets.length; i++) 
        {
            buckets[i] = new ArrayList<Integer>();
        }
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) 
        {
            buckets[entry.getValue()].add(entry.getKey());
        }
        //result array
        int[] result = new int[k];
        int counter = 0;
        for(int i=buckets.length-1;i>=0 ;i--)
        {
            //System.out.println(buckets[i]);
            if(buckets[i]!= null)
            {
                for(int num:buckets[i])
                {
                    //System.out.println(num);
                    result[counter++] = num;
                    if(counter == k) return result;
                }
            }
        }
        return result;
    }
}