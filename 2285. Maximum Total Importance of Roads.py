class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[] arr=new int[n];
        for(int i=0;i<roads.length;i++){
            arr[roads[i][0]]++;     //just count the no of times a city appears in the Roads Array
            arr[roads[i][1]]++;
        }
        long ans=0;
        Arrays.sort(arr);   //sorted the array
        for(int i=n-1;i>=0;i--){
            ans+=(long)(i+1)*arr[i];   //give high value and multiply from no of roads
        }
        return ans;
    }
}
