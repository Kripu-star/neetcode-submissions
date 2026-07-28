class Solution {
    public void dfs(StringBuilder st, int left, int right, int n, List<String> list) {
        if (left == n && right == n) {
            list.add(st.toString());
            return;
        }
        if (left > n || right > left) {
            return;
        }
        
        dfs(st.append("("), left + 1, right, n, list);

        st.deleteCharAt(st.length() - 1);
        
        

        dfs(st.append(")"), left, right + 1, n, list);
        st.deleteCharAt(st.length() - 1);
        
    }
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(sb, 0, 0, n, list);
        return list;
        // T.C. O(n*2^n) worst case upper bound
        //S.C. O(n)
    }
}
