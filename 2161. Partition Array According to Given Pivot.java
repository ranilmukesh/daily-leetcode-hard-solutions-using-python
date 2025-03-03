class Solution {
    public int[] pivotArray(int[] arr, int pivot) {
     int m[]=new int[arr.length];
        int i=0;
        int j=0;
        while(j<arr.length){
            if(arr[j]<pivot){
                m[i]=arr[j];
                i++;

            }
            j++;
        }
        int t=i;
        i=arr.length-1;
        j=arr.length-1;
        while(j>=0){
            if(arr[j]>pivot){
                m[i]=arr[j];
                i--;
            }
            j--;
        }
        int l=i;
    ;
        for(int v=t;v<=l;v++){
            m[v]=pivot;
        }
        return m;
        
    }
}
