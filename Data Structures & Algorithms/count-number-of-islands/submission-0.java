class Solution {
    
    static int[][]dir = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};
    public static void dfs(int i , int j, char[][] grid, int n, int m, boolean[][]vis ){
        if(i>=n || i<0 || j>=m || j<0 || grid[i][j]=='0'|| vis[i][j]) return;
        vis[i][j] = true;
        for(int k =0; k<4 ;k++){
            dfs(i+dir[k][0], j+dir[k][1], grid, n,m, vis);
        }
        
    }
    public int numIslands(char[][] grid) {
      int n = grid.length;
      int m = grid[0].length;
      int ans =0;
      boolean[][]vis = new boolean [n][m];
      for(boolean[]r:vis)Arrays.fill(r, false);
      for(int i =0; i<n ;i++)  {
        for(int j =0; j<m ;j++){
            if(grid[i][j]=='1' && !vis[i][j]){
                
                dfs(i,j, grid,n,m, vis);
                ans++;
            }
        }
      }
      return ans;
      // T.C O(m*n)
      // S.C O(m*n)
    }
}
