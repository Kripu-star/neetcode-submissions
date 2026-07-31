class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
      int n = gas.length;
      int idx = -1;
      
      for(int i =0; i<n ;i++){
        int curr = 0;
        int cnt =0, j = i;
        while(cnt<n){
            curr+=gas[j];
            if(curr<cost[j])break;
            curr-=cost[j];
            j++;
            j%=n;
            cnt++;
        }
        if(cnt==n){
            idx = i;
            break;
        }
      }
      return idx;
        
    }
}
