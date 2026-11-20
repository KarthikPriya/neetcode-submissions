class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0 || prerequisites == null)
            return true;
        //adjacency list of prerequisites to courses
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        int[] indegrees = new int[numCourses];
        //go through the prerequisites array and fill the adjacency list and indegrees array
        for(int[] node : prerequisites)
        {
            if(map.containsKey(node[1]))
            {
                List<Integer> list = map.get(node[1]);
                list.add(node[0]);
                map.put(node[1], list);
            }else
            {
                List<Integer> list = new ArrayList<>();
                list.add(node[0]);
                map.put(node[1], list);  
            }
            indegrees[node[0]]++;
        }
        //System.out.println(Arrays.toString(indegrees));
        int count = 0;
        for(int i=0;i<numCourses;i++)
        {
            if(indegrees[i] == 0)
            {    
                queue.add(i);
                count++;
            }
        }

        while(!queue.isEmpty())
        {

            int course = queue.poll();
            //System.out.println("processing this course now : "+count);

            List<Integer> list = map.get(course);
            if(list != null)
            {
                //System.out.println("am here : "+count);

                for(int i: list)
                {
                    indegrees[i]--;
                    if(indegrees[i] == 0)
                    {
                        queue.add(i);
                        count++;
                        //System.out.println("processing this course now : "+count);

                    }
                }
            }
        }
        return count == numCourses;
    }
}
