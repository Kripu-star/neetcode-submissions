class Solution {
    public void dfs(int[]nums, List<List<Integer>>list, List<Integer>sublist, int mask){
        if(sublist.size()== nums.length){
            list.add(new ArrayList<>(sublist));
            return;
        }
        for(int i =0; i<nums.length; i++){
        if((mask&(1<<i))==0){
           sublist.add(nums[i]);
           dfs(nums, list, sublist, mask|(1<<i));
           sublist.remove(sublist.size()-1);
        }
      }
    }
    public List<List<Integer>> permute(int[] nums) {

      //Let's use bitmasking here
      List<Integer>sublist = new ArrayList<>();
      List<List<Integer>>list = new ArrayList<>();
     
      dfs(nums, list, sublist,0);
      return list;
    }
    //T.C O(n*n!);
    //S.C O(n*n!);
    }