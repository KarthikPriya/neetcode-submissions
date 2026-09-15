class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals == null)
            return new int[][]{};
        //Sort the intervals in the Array
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[0],b[0]));
        //System.out.println(Arrays.toString(intervals));
        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        for(int[] interval:intervals)
        {
            int currStart = interval[0];
            int currEnd = interval[1];
            int prevEnd = result.get(result.size()-1)[1];
            int prevStart = 0;
            if(currStart<=prevEnd)
            {
                int newEnd = Math.max(currEnd,prevEnd);
                result.get(result.size()-1)[1] = newEnd;
            }else   
                result.add(new int[]{currStart, currEnd});

            //System.out.println(prevEnd + "--"+prevStart);
        }
        return result.toArray(new int[0][]);
    }
}

/*
[[1,3],[1,5],[6,7]]
Arrays.sort
[1,3]
[2,5]
---------------------
1 2 3 4 5
*/
