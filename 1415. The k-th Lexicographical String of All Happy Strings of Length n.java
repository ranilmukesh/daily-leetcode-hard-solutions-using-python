class Solution {
    
    String ans;
    int k;
    int n;
    public String getHappyString(int n, int k) {
        this.ans = "";
        this.k = k;
        this.n = n;

        dfs(new char[n], 0);        
        return ans;       
    }

    public boolean dfs(char[] curr, int idx){
        if(idx == n){
            if(k == 1){
                ans = new String(curr);
                return true;
            }
            k--;
            return false;
        }

        for(int i=0; i<3; i++){
            char c = (char)(i + 'a');
            if(idx == 0 || curr[idx-1] != c){
                char pc = curr[idx];
                curr[idx] = c;
                if(dfs(curr, idx+1)){
                    return true;
                }
                curr[idx] = pc;
            }            
        }

        return false;
    }
}
