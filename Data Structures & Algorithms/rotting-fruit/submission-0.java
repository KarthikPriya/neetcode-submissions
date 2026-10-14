class Solution {
    int[][] directions = {{0,-1},{0,1},{-1,0},{1,0}};
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0)
            return -1;
        Queue<int[]> queue = new LinkedList<>();
        //Gather all the rotten oranges
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j] == 2)
                    queue.add(new int[]{i,j});
            }
        }
        int counter = 0;
        //Process them
        while(!queue.isEmpty())
        {
            boolean infectedThisRound = false;
            int size = queue.size();
            for(int k = 0;k<size;k++)
            {
                int[] pos = queue.poll();
                
                for(int[] dir:directions)
                {

                    //System.out.println(pos[0] + "--"+pos[1]);
                    int newRow = pos[0] + dir[0];
                    int newCol = pos[1] + dir[1];
                    //System.out.println(newRow + "--pp"+newCol);
                    if(newRow < grid.length && newRow >=0 && newCol >=0 && newCol < grid[0].length && grid[newRow][newCol] == 1)
                    {
                        queue.add(new int[]{newRow, newCol});
                        //update the neighbor as rotten
                        grid[newRow][newCol] = 2;
                        infectedThisRound = true;
                    }
                }
            }
            if(infectedThisRound == true)
                counter++;
        }
        //check if any fresh oranges are remaining
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j] == 1)
                    return -1;
            }
        }
        return counter;
    }
}