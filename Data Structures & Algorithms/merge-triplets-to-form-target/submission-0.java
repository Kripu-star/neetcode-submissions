class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
      int n = triplets.length;
      boolean f1= false, f2 = false, f3 = false;
      for(int i =0; i<n; i++){
        int a = triplets[i][0];
        int b = triplets[i][1];
        int c = triplets[i][2];
        if(a> target[0]|| b>target[1]|| c>target[2])continue;
        if(a== target[0]) f1 = true;
        if(b==target[1]) f2 = true;
        if(c==target[2]) f3 = true;
      }
      return (f1 && f2 && f3);  
    }
}