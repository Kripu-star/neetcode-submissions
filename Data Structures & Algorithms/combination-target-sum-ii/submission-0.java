class Solution {
    public void dfs(int[] cand,List<List<Integer>>list, List<Integer>sublist, int target, int st){
        if(target == 0) {
           
            list.add(new ArrayList<>(sublist));
            return;

        }
        if(target<0 || st>= cand.length) return;
        for(int i =st ;i<cand.length; i++){
            if(i>st && cand[i] == cand[i-1]) continue;
            sublist.add(cand[i]);
            dfs(cand, list, sublist, target-cand[i], i+1);
            sublist.remove(sublist.size()-1);
           
           
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
       Arrays.sort(candidates);
       
       List<Integer>sublist = new ArrayList<>();
       
       //HashSet<List<Integer>>set = new HashSet<>();
       List<List<Integer>>list = new ArrayList<>();
       dfs(candidates, list, sublist, target,0);
       
       
       return list;
       //T.C O((2^n)*n)
       //S.C O(n)
    }
}
