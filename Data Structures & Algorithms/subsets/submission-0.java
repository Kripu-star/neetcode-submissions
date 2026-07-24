class Solution {
    public void func(int idx, int[]nums,List<List<Integer>>list , List<Integer>sublist ){
        if(idx== nums.length) {
            list.add(new ArrayList<>(sublist));
            return;
        }
        sublist.add(nums[idx]);
        func(idx+1, nums, list, sublist);
        sublist.remove(sublist.size()-1);
        func(idx+1, nums, list, sublist);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>list = new ArrayList<>();
        List<Integer>sublist = new ArrayList<>(); 
        func(0, nums, list, sublist);  
        return list;
    }
    //TC O(2^n*n)
    //SC O(2^n *n)
}
