class Solution {
    public int maximumSwap(int num) {
        //brute force pandren inga...
        char arr[]=Integer.toString(num).toCharArray();
        for(int i=0;i<arr.length;i++){
            char max=arr[i];
            char max2=arr[i];
            int x=0;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]>=max && j>x){
                max=arr[j];
                x=j;
                }
            }
            if(max!=max2){
            arr[x]=arr[i];
            arr[i]=max;
            break;
            }
        }
        return Integer.parseInt(new String(arr));
    }
}
