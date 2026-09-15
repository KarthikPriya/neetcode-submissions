class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals == null || newInterval == null)
            return intervals;
        List<int[]> result = new ArrayList<>();
        boolean added = false;
        for(int[] interval : intervals)
        {

            int currStart = interval[0];
            int currEnd = interval[1];
            if(added)
            {
                result.add(interval);
                continue;
            } 
            if(newInterval[1] < currStart)
            {
                result.add(newInterval);
                result.add(interval);
                added = true;
            }else if(currEnd< newInterval[0])
            {
                result.add(interval);
            }else
            {
                newInterval[0] = Math.min(currStart, newInterval[0]);
                newInterval[1] = Math.max(currEnd, newInterval[1]);
            }   
        }
        if(!added)
            result.add(newInterval);
        return result.toArray(new int[result.size()][]);
    }
}
