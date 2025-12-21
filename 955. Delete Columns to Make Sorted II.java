class Solution {
    public int minDeletionSize(String[] strs) {
        int n=strs[0].length();
        int ans=0;
        int size=strs.length;
        boolean[] sorted=new boolean[size-1];

        for(int k=0;k<n;k++){
            boolean delete=false;
            for(int i=0;i<size-1;i++){
                if(!sorted[i] && strs[i].charAt(k)>strs[i+1].charAt(k)){
                    delete=true;
                    break;
                }
            }
            if(delete){
                ans++;
            }else{
                for(int i=0;i<size-1;i++){
                      if(!sorted[i] && strs[i].charAt(k)<strs[i+1].charAt(k)){
                    sorted[i]=true;
                }
                }
            }
        }
        return  ans;
    }
}
