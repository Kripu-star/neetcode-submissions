class Solution {
    public boolean isNStraightHand(int[] hand, int gs) {
        int n = hand.length;
        HashMap<Integer,Integer>mp = new HashMap<>();
        Arrays.sort(hand);
        for(int num: hand){
            mp.put(num, mp.getOrDefault(num,0)+1);
        }
        for(int num:hand){
            if(mp.get(num)==0) continue;
            for(int i =0; i<gs;i++){
                if(!mp.containsKey(num+i)|| mp.get(num+i)==0) return false;
                mp.put(num+i, mp.get(num+i)-1);
            }
        }
        return true;
        //T.C. O(n log(n))
        //S.C. O(n)
    }
}
