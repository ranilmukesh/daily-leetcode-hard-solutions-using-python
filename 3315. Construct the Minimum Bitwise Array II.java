class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n=nums.size();
        int ans[]= new int[n];
        for(int i=0;i<n;i++){
            int p=nums.get(i);
            if(p==2){
                ans[i]=-1;
                continue;
            }
            int temp=p;
            int t=0;
            while((temp&1)==1){
                t++;
                temp>>=1;
            }
            int mask=~(1<<(t-1));
            ans[i]=p&mask;

        }
        return ans;
    }
}
