class Solution {
    public String minWindow(String s, String t) {
      int n1 = s.length(), n2 = t.length();
      if(n1<n2) return "";
      StringBuilder sb = new StringBuilder();
      HashMap<Character, Integer>mp = new HashMap<>();
      for(int i =0; i<n2;i++){
        char c = t.charAt(i);
        mp.put(c, mp.getOrDefault(c,0)+1);
      }
      int i =0, min = Integer.MAX_VALUE, st =-1, end =-1;
      while(i<=n1-n2){
        int j = n2+i;
        int cnt =0;
        HashMap<Character, Integer>mp2 = new HashMap<>(mp);
        for(int k =i; k<j;k++){
            if(mp2.containsKey(s.charAt(k)) && mp2.get(s.charAt(k))>0){
                cnt++;
                mp2.put(s.charAt(k), mp2.get(s.charAt(k))-1);
            }
        }
        if(cnt == n2) return s.substring(i,j);
        while(j<n1 && cnt<n2){
        if(mp2.containsKey(s.charAt(j)) && mp2.get(s.charAt(j))>0){
                cnt++;
                mp2.put(s.charAt(j), mp2.get(s.charAt(j))-1);
         }
         j++;
        }
        if(cnt == n2){
            int len = j-i;
            if(len<min){
                min = len;
                st =i;
                end = j;
            }
        }
        i++;
      }
      if(st==-1 || end ==-1)return "";
        return s.substring(st,end);
      
    }
}
