class Solution {
    public List<String> generateParenthesis(int n) {
        List<List<String>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) list.add(new ArrayList<>());
        list.get(0).add("");
        for (int k = 1; k <= n; k++) {
            for (int i = 0; i <= k - 1; i++) {
                // I want to add to list with index value k
                //  that kth will have multiple lists of strings like "", "", "" depending on the
                //  all i so we'll have combinations like for all the strings in list.get(i)X all
                //  the strings in list.get(k-i-1)

                for (String st1 : list.get(i)) {
                    for (String st2 : list.get(k - i - 1)) {
                        list.get(k).add("(" + st1 + ")" + st2);
                    }
                }
            }
        }
        return list.get(n);
        /* The number of valid parentheses combinations follows the Catalan Number sequence. Therefore, the time and space complexity are bounded by the
         n-th Catalan number, which is roughly O((4^n)/n*sqroot(n)) */
    }
}
