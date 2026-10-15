class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null)
            return -1;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int i=0;i<nums.length;i++)
        {
            if(heap.size() < k)
            {
                heap.add(nums[i]);
            }else
            {
                if(nums[i] <= heap.peek())
                    continue;
                heap.poll();
                heap.add(nums[i]);
            }
        }
        return heap.poll();
    }
}

//[1,2,3,4,5,6]
