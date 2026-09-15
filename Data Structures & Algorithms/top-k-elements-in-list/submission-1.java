class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums == null)
            return new int[0];
        HashMap<Integer, Integer> occurenceMap = new HashMap<>();
        ArrayList<Integer>[] buckets = (ArrayList<Integer>[]) new ArrayList[nums.length+1];
        for(int i:nums)
        {
           occurenceMap.put(i, occurenceMap.getOrDefault(i,0)+1);
        }
        for(int i=0;i<buckets.length;i++)
        {
            buckets[i] = new ArrayList<Integer>();
        }

        for (Map.Entry<Integer, Integer> entry : occurenceMap.entrySet()) 
        {
        //System.out.println("Key: " + key + ", Value: " + value);
        buckets[entry.getValue()].add(entry.getKey());
        }
        //iterate buckets in decreasing order and return the k elements
        int[] result = new int[k];
        int counter = 0;
        for(int i=buckets.length-1;i>=0;i--)
        {
            if(buckets[i]!= null)
            {
                for(int num:buckets[i])
                {
                    result[counter++] = num;
                    if(counter == k)return result;
                }
            }
        }
        return result;
    }
}



/*
[1,2,2,3,3,3]


*/