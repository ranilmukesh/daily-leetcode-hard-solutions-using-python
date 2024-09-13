class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int arrLen = arr.length;
        int queriesLen = queries.length;

        int xor[] = new int[arrLen];
        int ans[] = new int[queriesLen];
        xor[0] = arr[0];
        for(int i =1;i<arrLen;i++){
            xor[i] =  xor[i-1] ^ arr[i];
        }
        for(int i =0;i<queriesLen;i++){
            int left = queries[i][0];
            int right = queries[i][1];
            if(left == 0){
                ans[i] = xor[right];
            }
            else{
                ans[i] = xor[left-1] ^ xor[right];
            }
        }
        return ans;

    }
}
