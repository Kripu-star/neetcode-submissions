class Solution {
    
    static int[][]dir = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};
    public static void dfs(int i , int j, char[][] grid, int n, int m ){
        if(i>=n || i<0 || j>=m || j<0 || grid[i][j]=='0') return;
        grid[i][j] = '0';
        for(int k =0; k<4 ;k++){
            dfs(i+dir[k][0], j+dir[k][1], grid, n,m);
        }
        
    }
    public int numIslands(char[][] grid) {
      int n = grid.length;
      int m = grid[0].length;
      int ans =0;
      for(int i =0; i<n ;i++)  {
        for(int j =0; j<m ;j++){
            if(grid[i][j]=='1'){
                
                dfs(i,j, grid,n,m);
                ans++;
            }
        }
      }
      return ans;
      // T.C O(m*n)
      // S.C O(m*n) (just for the call stack no auxilliary space here)
    }
}
