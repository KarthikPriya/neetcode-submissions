class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null)
            return 0;
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        for(int i=0;i<nums.length;i++)
        {
            //System.out.println("element is "+nums[i]);
            if(heap.size() >= k)
            {
                if(heap.peek() < nums[i])
                {
                    heap.poll();
                    heap.add(nums[i]);
                }else
                    continue;
            }else
                heap.add(nums[i]);
                
        }
        return heap.poll();
    }
}
