class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0 || prerequisites == null)
            return true;
        int[] indegrees = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();

        //go through the courses and form indegrees array and the adjacency list
        for(int[] edge: prerequisites)
        {
            //edge[0] is dependent on edge[1]
            indegrees[edge[0]]++;
            if(!map.containsKey(edge[1]))
                map.put(edge[1], new ArrayList<>());
            map.get(edge[1]).add(edge[0]);
        }
        int count =0;
        for(int i=0;i<numCourses;i++)
        {
            if(indegrees[i] == 0)
            {
                queue.add(i);
                count++;
            }    
        }
        if(count == 0)
            return false;//there is no independent course
        while(!queue.isEmpty())
        {
            int course = queue.poll();
            List<Integer> list = map.get(course);
            if(list!= null)
            {
                for(int i: list)
                {
                    indegrees[i]--;
                    if(indegrees[i] == 0)
                    {
                        count++;
                        queue.add(i);
                    }
                }
            }
        }
        if(count == numCourses) 
            return true; 
        else
            return false;
    }
}