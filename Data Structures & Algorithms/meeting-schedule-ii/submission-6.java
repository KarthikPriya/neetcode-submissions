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
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals == null || intervals.size() == 0)
            return 0;
        //sorting intervals based on their start time
        intervals.sort((a,b)-> Integer.compare(a.start, b.start));
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(intervals.get(0).end);
        for(int i=1;i<intervals.size();i++)
        {
            if(queue.peek() <= intervals.get(i).start)
            {
                queue.poll();
            }
            queue.add(intervals.get(i).end);
        }
        return queue.size();
    }
}
