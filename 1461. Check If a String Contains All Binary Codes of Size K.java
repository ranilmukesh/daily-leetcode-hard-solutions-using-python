class Solution {
    public boolean hasAllCodes(String s, int k) {
        int total = 1 << k;
        int mask = total - 1;
        int n = s.length();
        int hash = 0,count = 0;
        boolean[] found = new boolean[total];
        for(int i=0;i<n;i++){
            hash = ((hash << 1) | s.charAt(i) -'0') & mask;
            if(i>=k-1){
                if(!found[hash]){
                    found[hash] = true;
                    count++;
                    if(count == total) return true;
                }                
            }
        }
        return false;
    }
}
