class pair{
    int num;
    int ind;
    public pair(int n,int i){
        this.num=n;
        this.ind=i;
    }
}
class Solution {
    public int getNum(int n,int[] mapping){
        int mul=1;
        int num=0;
        if(n==0){
            return mapping[0];
        }
        while(n>0){
            int rem=n%10;
            int digit=mapping[rem];
            num+=(digit*mul);
            mul*=10;
            n/=10;
        }
        return num;
    }
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int n=nums.length;
        pair arr[]=new pair[n];
        for(int i=0;i<n;i++){
            int number=getNum(nums[i],mapping);
            arr[i]=new pair(number,i);
        }
        Arrays.sort(arr,(a,b)->{
            if(a.num==b.num){
                return a.ind-b.ind;
            }
            return a.num-b.num;
        });
        int ans[]=new int[n];
        for(int i=0;i<n;i++){
            ans[i]=nums[arr[i].ind];
        }
        return ans;

    }
}
