class Solution {
    static int[][] dirs = new int[][] {{0,1}, {1,0}, {0,-1}, {-1,0}};
    private static  int bfs(int[][]grid, boolean[][]vis, Queue<int[]>q){
        
       int cnt =0;
        while(!q.isEmpty()){
            int sz = q.size();
            for(int i =0; i<sz;i++){
                int[]curr = q.poll();
                int i1 = curr[0];
                int j1 = curr[1];
                for(int k=0;k<4;k++){
                    int i2 = i1+dirs[k][0];
                    int j2 = j1+dirs[k][1];
                    if(i2<0 || j2<0 || i2>= grid.length || j2>= grid[0].length || grid[i2][j2]!=1 || vis[i2][j2]) continue;
                    vis[i2][j2] = true;
                    q.add(new int[]{i2, j2});
                }
            }
            if(q.size()>0)cnt++;
        }
        return cnt;

    }
    public int orangesRotting(int[][] grid) {
      //bfs
      int m = grid.length, n = grid[0].length;
      boolean [][] vis = new boolean[m][n];
      int total=0;
      Queue<int[]>q = new ArrayDeque<>();
      for(int i =0; i<m ;i++){
        for(int j =0;j<n;j++){
            if(!vis[i][j] && grid[i][j]==2)
            {
                vis[i][j] = true;
                
                q.add(new int[]{i,j});
            }
        }
      } 
      
      
      total = bfs( grid, vis,q );

      for(int i =0; i<m;i++){
        for(int j =0; j<n; j++){
            if(!vis[i][j] && grid[i][j]==1) return -1;
        }
      }
      return total;
    }
}
