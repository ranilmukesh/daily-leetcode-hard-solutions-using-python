class Solution {
    public long minimumSteps(String s) {
        char [] arr = s.toCharArray();
        
        int j = arr.length-1;
        long ans=0;
        int counter=0;
        while(j >= 0){
            if(arr[j] == '0') 
                counter++;
            else if(arr[j] == '1'){ 
                ans += counter; 
            }
            j--; 
        }
        return ans;
    }
}
