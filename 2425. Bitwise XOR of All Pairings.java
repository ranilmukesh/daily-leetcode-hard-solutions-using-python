class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int ans=0;
         int ans1=0;
        for(int i=0;i<nums1.length;i++){
            ans^=nums1[i];

        }
        for(int i=0;i<nums2.length;i++){
            ans1^=nums2[i];

        }
        if(nums1.length%2==0){
            if(nums2.length%2==0){
                return 0;
            }
            else {
                return  ans;
            }
        }
        else{
             if(nums2.length%2==0){
                return ans1;
            }
            else {
                return  ans^ans1;
            }

        }
        
        
    }
}
