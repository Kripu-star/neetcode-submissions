class Solution {
    public String minWindow(String s, String t) {
      int n1 = s.length(), n2 = t.length();
      if(n1<n2) return "";
      
      HashMap<Character, Integer>mp = new HashMap<>();
      

      for(int i=0;i<n2;i++ ){
       char c2 = t.charAt(i);
        mp.put(c2, mp.getOrDefault(c2,0)+1);
      }
      
      int target = n2;
      int l= 0, r=0, min = Integer.MAX_VALUE, st = -1;
      while(r<n1){
        char c = s.charAt(r);
       
        if(mp.containsKey(c)  ){
            if(mp.get(c)>0)target--;
            mp.put(c, mp.get(c)-1);
        }
        while(target ==0){
            if(r-l+1<min){
                min = r-l+1;
                st =l;
            }
            char c2 = s.charAt(l);
          if(mp.containsKey(c2)){
            mp.put(c2, mp.get(c2)+1);
            if(mp.get(c2)>0) target++;

           }
           l++;
        }

        r++;

      }
      if(st==-1) return "";
      return s.substring(st, st+min);
       // T.C O(n)
       // S.C O(k)
      
    }
}
