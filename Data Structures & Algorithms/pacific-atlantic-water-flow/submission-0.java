class Solution {
    static int [][] dirs = new int[][]{{-1,0}, {0,-1}, {1,0}, {0,1}};
     static Boolean po, ao;
    private static void dfs(int r, int c, int [][]heights, boolean [][]vis){
        if( po && ao) return;
        if(r == 0 || c == 0) po = true;
        if(r == heights.length-1 || c == heights[0].length-1) ao = true;
        vis[r][c] = true;
        for(int i =0; i<4; i++){
            int r1 = r+dirs[i][0];
            int c1 = c+dirs[i][1];
            if(r1<0 || c1<0 || r1>=heights.length || c1>= heights[0].length 
                ||heights[r1][c1]> heights[r][c]||vis[r1][c1])continue;
            dfs(r1, c1, heights, vis);
        }

    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
       int m = heights.length;
       int n = heights[0].length;
       List<List<Integer>>list = new ArrayList<>();
       for(int i =0; i<m ;i++){
        for(int j=0; j<n; j++){
            boolean [][] vis = new boolean[m][n];
            po = false;
            ao = false;
            dfs(i, j, heights, vis);
            if(po && ao) list.add(Arrays.asList(i,j));
        }
       } 
       return list;
    }
}
