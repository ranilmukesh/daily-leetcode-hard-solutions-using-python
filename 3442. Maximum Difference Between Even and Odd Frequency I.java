class Solution {
    public int maxDifference(String s) {
        int maxodd = 0;
        int mineven  = 100;
        int[] map = new int[27];
        for(int i=0;i<s.length();i++){
            map[s.charAt(i)-'a']++;
        }
        for(int i : map){
            if(i!=0 && i%2==0) mineven=Math.min(mineven,i);
            else maxodd=Math.max(maxodd,i);
        }
        return (maxodd-mineven);
    }
}
