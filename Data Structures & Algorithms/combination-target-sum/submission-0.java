class Solution {
    public void func(int idx, int[]nums,  List<List<Integer>>list,List<Integer>sublist, int target, int sum ){
         if(sum==target){
            list.add(new ArrayList<>(sublist));
            return;
         }
        if(idx == nums.length ||sum>target){
           return;
        }
        sum+=nums[idx];
        sublist.add(nums[idx]);
        func(idx, nums, list, sublist, target, sum);
        sum-=sublist.get(sublist.size()-1);
        sublist.remove(sublist.size()-1);
        func(idx+1, nums, list, sublist, target, sum);
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer>sublist = new ArrayList<>();
        List<List<Integer>>list = new ArrayList<>();
        func(0, nums, list, sublist, target, 0);
        return list;
        //T.C O(2^n *n)
        //S.C O(2^n *n)
    }
}
