class Solution {
    int[][] directions = {{0,1},{1,0},{-1,0},{0,-1}};
    int numberOfIslands = 0;
    public int numIslands(char[][] grid) {
        if(grid == null)
            return 0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j] == '1')
                {
                    numberOfIslands++;
                    grid[i][j] = '2';
                    bfs(grid,i,j);
                }
            }
        }
        return numberOfIslands;
    }
    public void bfs(char[][] grid, int r, int c)
    {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r,c});
        while(!queue.isEmpty())
        {
            int[] newDir = queue.poll();
            
            for(int[] dir : directions)
            {
                int newR = newDir[0];
                int newC = newDir[1];
                newR += dir[0];
                newC += dir[1];
                if(newR >= 0 && newR<grid.length && newC >=0 && newC<grid[0].length && grid[newR][newC] == '1')
                {
                    grid[newR][newC] = '2';
                    queue.add(new int[]{newR,newC});
                }    
            }
        }
    }
}