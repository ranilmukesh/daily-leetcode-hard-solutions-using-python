import java.util.*;
class Solution {
    public void sortColors(int[] arr) {
        // Arrays.sort(arr);
        int zero=0,j=0;
        int one=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                zero++;
            }
        }
        for(int i=j;i<arr.length;i++){
            if(arr[i]==1){
                one++;
            }
        }
        for(int i=0;i<arr.length;i++){
            if(i<zero){
                arr[i]=0;
            }else if(i<zero+one) {
                arr[i]=1;
            }else{
                arr[i]=2;
            }
        }
        return;
    }
}
