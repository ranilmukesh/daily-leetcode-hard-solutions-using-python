class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        if(k==1 && nums.size()>1) return true;
        boolean res = false;
        for(int i=0;i<nums.size()+1-k*2;i++){
            res = false;
            for(int j=i+1;j-i<k*2 && j<nums.size();j++){
                if(nums.get(j-1)>=nums.get(j) && j!=i+k){
                    res=false;
                    break;
                }
                else{
                    res = true;
                } 
            }
            if (res) return res;
        }
        return res;
    }

}
