class Solution {
    static int[][] dir = new int[][]{{1,0},{-1,0}, {0,1}, {0,-1}};
    static boolean flag = false;
    private static void dfs(char[][]board, String word, int r, int c, int idx, boolean[][]vis){
        if(idx == word.length()) {
            flag = true;
            return;
        }
        if(r<0 || c<0 || r>=board.length|| c>=board[0].length ||board[r][c]!=word.charAt(idx)|| vis[r][c]) return;
        vis[r][c] = true;
        for(int i =0;i<4;i++){
            dfs(board, word, r+dir[i][0], c+dir[i][1], idx+1, vis);
            
        }
        vis[r][c] = false;
    }
    public boolean exist(char[][] board, String word) {
        flag = false;
        int m = board.length;
        int n = board[0].length;
        int n1 = word.length();
        
        for(int i =0; i<m;i++){
            for(int j =0;j<n;j++){
                if(board[i][j]!=word.charAt(0))continue;
                boolean[][]vis = new boolean[m][n];
                dfs(board, word,  i,  j, 0, vis);
                if (flag) return true;
            }
        }
        return flag;

        //T.C. O(m*n*3^n1)
        //S.C. O(m*n +n1)
    }
}
