class Solution {
    public int findMinDifference(List<String> timePoints) {

       int ans=Integer.MAX_VALUE;;
       int n = timePoints.size();

        int[] arr = new int[n];

        for(int i=0;i<n;i++){

            int minutes = Integer.valueOf(timePoints.get(i).substring(0,2))*60;
            minutes=minutes+Integer.valueOf(timePoints.get(i).substring(3,5));
            arr[i]=minutes;
        }

        Arrays.sort(arr);
        //System.out.println(Arrays.toString(arr));

        for(int i=1;i<n;i++){
            ans=Math.min(arr[i]-arr[i-1],ans);
        }

        ans=Math.min(ans, (arr[0]+1440)-arr[n-1]);

        return ans;
        
    }
}
