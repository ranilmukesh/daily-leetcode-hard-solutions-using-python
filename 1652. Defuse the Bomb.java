class Solution {
    int getVal(int[] code, int n, int ind,int k){
        if(k == 0)return 0;
        else if(k < 0){
            k = k*-1;
            int sum = 0;
            if(ind == 0)ind = n-1; 
            else ind--;
            while(k-- > 0){
                sum += code[ind];
                ind--;
                if(ind < 0)ind = n-1;
            }
            return sum;
        }
        else{
            int sum = 0;
            if(ind == n-1)ind = 0; 
            else ind++;
            while(k-- > 0){
                sum += code[ind];
                ind++;
                if(ind >= n)ind = 0;
            }
            return sum;
        }
    }
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            ans[i] = getVal(code,n,i,k); 
        }
        return ans;
    }
}
