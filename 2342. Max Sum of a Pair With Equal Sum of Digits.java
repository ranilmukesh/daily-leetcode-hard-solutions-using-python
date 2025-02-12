class Solution {
    public int maximumSum(int[] nums) {
        int[][] arr=new int[100][2];
        int s=0,d=0;
        for(int n:nums){
            int t=n;
            s=0;
            while(n!=0){
                d=n%10;
                s+=d;
                n/=10;
            }
            if(arr[s][0]==0){
                arr[s][0]=t;
            }
            else if(arr[s][1]==0){
                arr[s][1]=Math.max(arr[s][0],t);
                arr[s][0]=Math.min(arr[s][0],t);
            }
            else{
                if(t>arr[s][1]){
                    arr[s][0]=arr[s][1];
                    arr[s][1]=t;
                }
                else if(t>arr[s][0]){
                    arr[s][0]=t;
                }
            }
        }
        int max=0;
        for(int[] a:arr){
            if(a[0]==0||a[1]==0){
                continue;
            }
            max=Math.max(max,a[0]+a[1]);
        }
        return max>0?max:-1;
    }
}
