class Solution {
    public void dfs(int[]nums, List<List<Integer>>list, List<Integer>sublist , boolean[]vis ){
        if(sublist.size()==nums.length){
            list.add(new ArrayList<>(sublist));
            return;
        }
        for(int i =0; i<nums.length; i++){
            if(vis[i])continue;
            sublist.add(nums[i]);
            vis[i] = true;
            dfs(nums, list, sublist, vis);
            vis[i] = false;
            sublist.remove(sublist.size()-1);
       }
       return;
    }
    public List<List<Integer>> permute(int[] nums) {
       List<List<Integer>>list = new ArrayList<>();
       boolean[]vis = new boolean[nums.length];
       List<Integer>sublist = new ArrayList<>();
       dfs(nums, list, sublist, vis);
       return list;
    }
    //This is a backtracking solution as we are selecting and then we are removing once condition met and baacktracking to find more solution
    //S.C. = height which is n so O(n) also the visited arrat taking n sized array
    //T.C = no. of nodes * each node work done
    // so there are n! nodes---

}/* 
  level 1 -> n
        +
  level 2 -> n*(n-1)
        +
  level 3 -> n*(n-1)* (n-2)
        +
  .
  .
  .
        +
  level n -> n*(n-1)*(n-2)*...*(n-(n-1)) = n*(n-1)*(n-2)*....*1 = n!
 */
 //at all the levels we are adding one lement in the sublist O(1)
 // at the leaf node we're adding the sublist in list (copying shallow copy) so O(n) work
 // hence total work done is O(n*n!)
 //T.C O(n*n!)

