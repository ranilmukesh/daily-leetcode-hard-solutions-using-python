class Solution {
    public String smallestNumber(String pattern) {
       char [] arr= pattern.toCharArray();
       int d=0;
       for(char c: arr){
          if(c=='D'){
             d++;
          }
       }
       int p_size=arr.length;
       char [] nums= new char[p_size+1];
       for(int i=0;i<p_size+1;i++){
          nums[i]=(char)(49+i);
       }
       for(int j=0;j<d;j++){
       for(int i=0;i<p_size;i++){
           if(arr[i]=='I'){
              if(nums[i]>nums[i+1]){
                nums[i]=(char)(nums[i+1]+nums[i]);
                nums[i+1]=(char)(nums[i]-nums[i+1]);
                nums[i]=(char)(nums[i]-nums[i+1]);
              }
           }
           else{
            if(nums[i]<nums[i+1]){
                 nums[i]=(char)(nums[i+1]+nums[i]);
                nums[i+1]=(char)(nums[i]-nums[i+1]);
                nums[i]=(char)(nums[i]-nums[i+1]);
              }
           }
       }
       }
       return new String(nums);
    }
}
