/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        if(intervals == null)
            return false;
        intervals.sort((a,b)->Integer.compare(a.start,b.start));
        int prevEnd = Integer.MIN_VALUE;
        for(Interval interval:intervals)
        {
            if(prevEnd == Integer.MIN_VALUE)
            {
                prevEnd = interval.end;
                continue;
            }
            if(interval.start < prevEnd)
                return false;
            prevEnd = interval.end;
        }
        return true;
    }
}
