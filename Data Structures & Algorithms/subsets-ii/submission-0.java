class Solution {
    public void dfs(int[] nums,HashSet<List<Integer>>list, List<Integer>sublist, int idx){
        if(idx == nums.length){
            ArrayList<Integer>dummy = new ArrayList<>(sublist);
            Collections.sort(dummy);
            list.add(new ArrayList<>(dummy));
            return;
        }
        
        sublist.add(nums[idx]);
        dfs(nums, list, sublist, idx+1);
        sublist.remove(sublist.size()-1);
        dfs(nums, list, sublist, idx+1);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
         HashSet<List<Integer>>set = new HashSet<>();
        List<Integer>sublist = new ArrayList<>();
        dfs(nums, set, sublist, 0);
         List<List<Integer>>list = new ArrayList<>(set);
        return list;
    }
}
